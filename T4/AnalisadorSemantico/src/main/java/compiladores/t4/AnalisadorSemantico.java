package compiladores.t4;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import compiladores.t4.AnalisadorParser.CmdAtribuicaoContext;
import compiladores.t4.AnalisadorParser.CmdRetorneContext;
import compiladores.t4.AnalisadorParser.Declaracao_constanteContext;
import compiladores.t4.AnalisadorParser.Declaracao_globalContext;
import compiladores.t4.AnalisadorParser.Declaracao_tipoContext;
import compiladores.t4.AnalisadorParser.Declaracao_variavelContext;
import compiladores.t4.AnalisadorParser.IdentificadorContext;
import compiladores.t4.AnalisadorParser.ParametroContext;
import compiladores.t4.AnalisadorParser.Parcela_unarioContext;
import compiladores.t4.AnalisadorParser.ProgramaContext;
import compiladores.t4.AnalisadorParser.Tipo_basico_identContext;
import compiladores.t4.AnalisadorParser.VariavelContext;
import compiladores.t4.Tabela.EntradaTabelaDeSimbolos;
import java.util.Iterator;

public class AnalisadorSemantico extends AnalisadorBaseVisitor {
    
    Escopo escoposAninhados = new Escopo(Tabela.Tipos.VOID);
    @Override
    public Object visitPrograma(ProgramaContext ctx) {  return super.visitPrograma(ctx);
    }

    //método chamado quando o analisador encontra uma declaração de constante no código fonte constante foi declarada anteriormente, adicionar a constante à tabela 
    //de símbolos gerar um erro semântico caso a constante já tenha sido declarada 
    @Override
    public Object visitDeclaracao_constante(Declaracao_constanteContext ctx) {
        Tabela atual = escoposAninhados.getEscopo();
        if (atual.existe(ctx.IDENT().getText())) {
            SemanticoUtils.adicionarErroSemantico(ctx.start, "constante" + ctx.IDENT().getText()+ " ja declarado anteriormente");
        } else {
            Tabela.Tipos tipo = Tabela.Tipos.INT;
            Tabela.Tipos aux = SemanticoUtils.getTipo(ctx.tipo_basico().getText()) ;
            if(aux != null)
                tipo = aux;
            atual.adiciona(ctx.IDENT().getText(), tipo, Tabela.Structure.CONST);
        }
    return super.visitDeclaracao_constante(ctx);
    }

    //essa função é responsável por verificar se um novo tipo foi declarado anteriormente, adicionar o novo tipo à tabela de símbolos, juntamente com seus identificadores
    @Override
    public Object visitDeclaracao_tipo(Declaracao_tipoContext ctx) {
        Tabela atual = escoposAninhados.getEscopo();
        if (atual.existe(ctx.IDENT().getText())) {
             SemanticoUtils.adicionarErroSemantico(ctx.start, "tipo " + ctx.IDENT().getText()+ " declarado duas vezes num mesmo escopo");
        } else {
            Tabela.Tipos tipo = SemanticoUtils.getTipo(ctx.tipo().getText());
            if(tipo != null)
                atual.adiciona(ctx.IDENT().getText(), tipo, Tabela.Structure.TIPO);
            else if(ctx.tipo().registro() != null){
                ArrayList<Tabela.EntradaTabelaDeSimbolos> varReg = new ArrayList<>();
                Iterator<VariavelContext> varIterator = ctx.tipo().registro().variavel().iterator();
                while (varIterator.hasNext()) {
                    VariavelContext va = varIterator.next();
                    Tabela.Tipos tipoReg = SemanticoUtils.getTipo(va.tipo().getText());
                    
                    Iterator<IdentificadorContext> idIterator = va.identificador().iterator();
                    while (idIterator.hasNext()) {
                        IdentificadorContext id2 = idIterator.next();
                        varReg.add(atual.new EntradaTabelaDeSimbolos(id2.getText(), tipoReg, Tabela.Structure.TIPO));
                    }
                }
                if (atual.existe(ctx.IDENT().getText())) {
                    SemanticoUtils.adicionarErroSemantico(ctx.start, "identificador " + ctx.IDENT().getText() + " ja declarado anteriormente");
                }
                else{
                    atual.adiciona(ctx.IDENT().getText(), Tabela.Tipos.REG, Tabela.Structure.TIPO);
                }

                for(Tabela.EntradaTabelaDeSimbolos re : varReg){
                    String nameVar = ctx.IDENT().getText() + '.' + re.name;
                    if (atual.existe(nameVar)) {
                        SemanticoUtils.adicionarErroSemantico(ctx.start, "identificador " + nameVar + " ja declarado anteriormente");
                    }
                    else{
                        atual.adiciona(re);
                        atual.adiciona(ctx.IDENT().getText(), re);
                    }
                }
            }
            Tabela.Tipos t =  SemanticoUtils.getTipo(ctx.tipo().getText());
            atual.adiciona(ctx.IDENT().getText(), t, Tabela.Structure.TIPO);
        }   return super.visitDeclaracao_tipo(ctx);
    }

    //verifica se os identificadores de tipos personalizados (identificadores de tipo) utilizados no código foram previamente declarados. 
    //Se um identificador de tipo não tiver sido declarado, um erro semântico é gerado
    @Override
    public Object visitTipo_basico_ident(Tipo_basico_identContext ctx) {
        if(ctx.IDENT() != null){
            boolean existe = false;
            for(Tabela escopo : escoposAninhados.getPilha()) {
                if(escopo.existe(ctx.IDENT().getText())) {
                    existe = true;
                }
            }
            if(!existe){
                SemanticoUtils.adicionarErroSemantico(ctx.start, "tipo " + ctx.IDENT().getText() + " nao declarado");
            }
        }   return super.visitTipo_basico_ident(ctx);
    }

    //verificar e adicionar as declarações globais (funções ou procedimentos) à tabela de símbolos, 
    //tratando corretamente os parâmetros e gerando erros semânticos quando necessário
    @Override
    public Object visitDeclaracao_global(Declaracao_globalContext ctx) {
        Tabela atual = escoposAninhados.getEscopo();
        Object ret;
        if (atual.existe(ctx.IDENT().getText())) {
            SemanticoUtils.adicionarErroSemantico(ctx.start, ctx.IDENT().getText() + " ja declarado anteriormente");
            ret = super.visitDeclaracao_global(ctx);
        } else {
            Tabela.Tipos returnTypeFunc = Tabela.Tipos.VOID;
            if(ctx.getText().startsWith("funcao")){
                returnTypeFunc = SemanticoUtils.getTipo(ctx.tipo_estendido().getText());
                atual.adiciona(ctx.IDENT().getText(), returnTypeFunc, Tabela.Structure.FUNC);
            }
            else{
                returnTypeFunc = Tabela.Tipos.VOID;
                atual.adiciona(ctx.IDENT().getText(), returnTypeFunc, Tabela.Structure.PROC);
            }
            escoposAninhados.create(returnTypeFunc);
            Tabela escopoAntigo = atual;
            atual = escoposAninhados.getEscopo();
            if(ctx.parametros() != null){
                for(ParametroContext p : ctx.parametros().parametro()){
                    for (IdentificadorContext id : p.identificador()) {
                        String nomeId = "";
                        int i = 0;
                        for(TerminalNode ident : id.IDENT()){
                            if(i++ > 0)
                                nomeId += ".";
                            nomeId += ident.getText();
                        }
                        if (atual.existe(nomeId)) {
                            SemanticoUtils.adicionarErroSemantico(id.start, "identificador " + nomeId + " ja declarado anteriormente");
                        } else {
                            Tabela.Tipos tipo = SemanticoUtils.getTipo(p.tipo_estendido().getText());
                            if(tipo != null){
                                EntradaTabelaDeSimbolos in = atual.new EntradaTabelaDeSimbolos(nomeId, tipo, Tabela.Structure.VAR);
                                atual.adiciona(in);
                                escopoAntigo.adiciona(ctx.IDENT().getText(), in);
                            }
                            else{
                                TerminalNode identTipo =    p.tipo_estendido().tipo_basico_ident() != null  
                                                            && p.tipo_estendido().tipo_basico_ident().IDENT() != null 
                                                            ? p.tipo_estendido().tipo_basico_ident().IDENT() : null;
                                if(identTipo != null){
                                    ArrayList<Tabela.EntradaTabelaDeSimbolos> regVars = null;
                                    boolean found = false;
                                    for(Tabela t: escoposAninhados.getPilha()){
                                        if(!found){
                                            if(t.existe(identTipo.getText())){
                                                regVars = t.getTypeProperties(identTipo.getText());
                                                found = true;
                                            }
                                        }
                                    }
                                    if(atual.existe(nomeId)){
                                        SemanticoUtils.adicionarErroSemantico(id.start, "identificador " + nomeId + " ja declarado anteriormente");
                                    } else{
                                        EntradaTabelaDeSimbolos in = atual.new EntradaTabelaDeSimbolos(nomeId, Tabela.Tipos.REG, Tabela.Structure.VAR);
                                        atual.adiciona(in);
                                        escopoAntigo.adiciona(ctx.IDENT().getText(), in);
                                        for(Tabela.EntradaTabelaDeSimbolos s: regVars){
                                            atual.adiciona(nomeId + "." + s.name, s.tipo, Tabela.Structure.VAR);
                                        }   
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ret = super.visitDeclaracao_global(ctx);
            escoposAninhados.dropEscopo();
        }   
        return ret;
    }

    //por verifica se um identificado é válido, ou seja, se ele foi previamente declarado em algum dos escopos presentes na pilha de escopos. 
    //Se um identificador não tiver sido declarado, um erro semântico é gerado
    @Override
    public Object visitIdentificador(IdentificadorContext ctx) {
        String Var = "";
        int i = 0;
        for(TerminalNode id : ctx.IDENT()){
            if(i++ > 0)
                Var += ".";
            Var += id.getText();
        }
        boolean erro = true;
        for(Tabela escopo : escoposAninhados.getPilha()) {
            if(escopo.existe(Var)) {
                erro = false;
            }
        }
        if(erro)
            SemanticoUtils.adicionarErroSemantico(ctx.start, "identificador " + Var + " nao declarado");    return super.visitIdentificador(ctx);
    }

    //verifica e adiciona as declarações de variáveis à tabela de símbolos, tratando corretamente os diferentes tipos de variáveis, 
    //incluindo variáveis com membros de tipos registro e também adiciona erros semânticos quando identificadores duplicados são encontrados
    @Override
    public Object visitDeclaracao_variavel(Declaracao_variavelContext ctx) {
        Tabela atual = escoposAninhados.getEscopo();
        for (IdentificadorContext id : ctx.variavel().identificador()) {
            String nomeId = "";
            int i = 0;
            for(TerminalNode ident : id.IDENT()){
                if(i++ > 0)
                    nomeId += ".";
                nomeId += ident.getText();
            }
            if (atual.existe(nomeId)) {
                SemanticoUtils.adicionarErroSemantico(id.start, "identificador " + nomeId + " ja declarado anteriormente");
            } else {
                Tabela.Tipos tipo = SemanticoUtils.getTipo(ctx.variavel().tipo().getText());
                if(tipo != null)
                    atual.adiciona(nomeId, tipo, Tabela.Structure.VAR);
                else{
                    TerminalNode identTipo =    ctx.variavel().tipo() != null
                                                && ctx.variavel().tipo().tipo_estendido() != null 
                                                && ctx.variavel().tipo().tipo_estendido().tipo_basico_ident() != null  
                                                && ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT() != null 
                                                ? ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT() : null;
                    if(identTipo != null){
                        ArrayList<Tabela.EntradaTabelaDeSimbolos> regVars = null;
                        boolean found = false;
                        for(Tabela t: escoposAninhados.getPilha()){
                            if(!found){
                                if(t.existe(identTipo.getText())){
                                    regVars = t.getTypeProperties(identTipo.getText());
                                    found = true;
                                }
                            }
                        }
                        if(atual.existe(nomeId)){
                            SemanticoUtils.adicionarErroSemantico(id.start, "identificador " + nomeId
                                        + " ja declarado anteriormente");
                        } else{
                            atual.adiciona(nomeId, Tabela.Tipos.REG, Tabela.Structure.VAR);
                            for(Tabela.EntradaTabelaDeSimbolos s: regVars){
                                atual.adiciona(nomeId + "." + s.name, s.tipo, Tabela.Structure.VAR);
                            }   
                        }
                    }
                    else if(ctx.variavel().tipo().registro() != null){
                        ArrayList<Tabela.EntradaTabelaDeSimbolos> varReg = new ArrayList<>();
                        for(VariavelContext va : ctx.variavel().tipo().registro().variavel()){
                            Tabela.Tipos tipoReg =  SemanticoUtils.getTipo(va.tipo().getText());
                            for(IdentificadorContext id2 : va.identificador()){
                                varReg.add(atual.new EntradaTabelaDeSimbolos(id2.getText(), tipoReg, Tabela.Structure.VAR));
                            }
                        }  
                        atual.adiciona(nomeId, Tabela.Tipos.REG, Tabela.Structure.VAR);

                        for(Tabela.EntradaTabelaDeSimbolos re : varReg){
                            String nameVar = nomeId + '.' + re.name;
                            if (atual.existe(nameVar)) {
                                SemanticoUtils.adicionarErroSemantico(id.start, "identificador " + nameVar + " ja declarado anteriormente");
                            }
                            else{
                                atual.adiciona(re);
                                atual.adiciona(nameVar, re.tipo, Tabela.Structure.VAR);
                            }
                        }
                    }
                    else{
                        atual.adiciona(id.getText(), Tabela.Tipos.INT, Tabela.Structure.VAR);
                    }
                }
            }
        }   
        return super.visitDeclaracao_variavel(ctx);
    }

    // verifica se o comando retorne é permitido no escopo atual. Se o escopo for um procedimento 
    //(com tipo de retorno VOID), o comando retorne não é permitido e um erro semântico é gerado
    @Override
    public Object visitCmdRetorne(CmdRetorneContext ctx) {
        if(escoposAninhados.getEscopo().returnType == Tabela.Tipos.VOID){
            SemanticoUtils.adicionarErroSemantico(ctx.start, "comando retorne nao permitido nesse escopo");
        }   return super.visitCmdRetorne(ctx);
    }

    //verifica a compatibilidade da atribuição entre a expressão do lado direito e a variável do lado esquerdo. 
    //Se a atribuição não for compatível (por exemplo, tentando atribuir um valor real a uma variável inteira), um erro semântico é gerado. 
    @Override
    public Object visitCmdAtribuicao(CmdAtribuicaoContext ctx) {
        Tabela.Tipos tipoExpressao = SemanticoUtils.verTipo(escoposAninhados, ctx.expressao());
        boolean error = false;
        String pointerChar = ctx.getText().charAt(0) == '^' ? "^" : "";
        String Var = "";
        int i = 0;
        for(TerminalNode id : ctx.identificador().IDENT()){
            if(i++ > 0)
                Var += ".";
            Var += id.getText();
        }
        if (tipoExpressao != Tabela.Tipos.INVALIDO) {
            boolean found = false;
            for(Tabela escopo : escoposAninhados.getPilha()){
                if (escopo.existe(Var) && !found)  {
                    found = true;
                    Tabela.Tipos tipoVariavel = SemanticoUtils.verTipo(escoposAninhados, Var);
                    Boolean varNumeric = tipoVariavel == Tabela.Tipos.REAL || tipoVariavel == Tabela.Tipos.INT;
                    Boolean expNumeric = tipoExpressao == Tabela.Tipos.REAL || tipoExpressao == Tabela.Tipos.INT;
                    if  (!(varNumeric && expNumeric) && tipoVariavel != tipoExpressao && tipoExpressao != Tabela.Tipos.INVALIDO) {
                        error = true;
                    }
                } 
            }
        } else{
            error = true;
        }

        if(error){
            Var = ctx.identificador().getText();
            SemanticoUtils.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + pointerChar + Var );
        }
        return super.visitCmdAtribuicao(ctx);
    }

    //responsável por verificar se a chamada de função ou procedimento possui os parâmetros corretos 
    //e compatíveis com os declarados na declaração da função ou procedimento. Se houver incompatibilidade nos parâmetros, um erro semântico é gerado
    @Override
    public Object visitParcela_unario(Parcela_unarioContext ctx) {
        Tabela atual = escoposAninhados.getEscopo();
        if(ctx.IDENT() != null){
            String name = ctx.IDENT().getText();
            if(atual.existe(ctx.IDENT().getText())){
                List<EntradaTabelaDeSimbolos> params = atual.getTypeProperties(name);
                boolean error = false;
                if(params.size() != ctx.expressao().size()){
                    error = true;
                } else {
                    for(int i = 0; i < params.size(); i++){
                        if(params.get(i).tipo != SemanticoUtils.verTipo(escoposAninhados, ctx.expressao().get(i))){
                            error = true;
                        }
                    }
                }
                if(error){
                    SemanticoUtils.adicionarErroSemantico(ctx.start, "incompatibilidade de parametros na chamada de " + name);
                }
            }
        }
        return super.visitParcela_unario(ctx);
    }
}
