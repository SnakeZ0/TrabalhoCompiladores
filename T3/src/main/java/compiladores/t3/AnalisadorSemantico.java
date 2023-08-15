package compiladores.t3;

import compiladores.t3.AnalisadorParser.CmdAtribuicaoContext;
import compiladores.t3.AnalisadorParser.Declaracao_constanteContext;
import compiladores.t3.AnalisadorParser.Declaracao_globalContext;
import compiladores.t3.AnalisadorParser.Declaracao_variavelContext;
import compiladores.t3.AnalisadorParser.IdentificadorContext;
import compiladores.t3.AnalisadorParser.Tipo_basico_identContext;
import java.util.Iterator;

public class AnalisadorSemantico extends AnalisadorBaseVisitor {

    // Cria os escopos como variavel global
    Escopo escoposAninhados = new Escopo();

    @Override
    public Object visitCorpo(AnalisadorParser.CorpoContext ctx) {
        Iterator<AnalisadorParser.CmdContext> iterator = ctx.cmd().iterator();
        // Cria o escopo da função principal
        while (iterator.hasNext()) {
            AnalisadorParser.CmdContext cmd = iterator.next();
            if (cmd.cmdRetorne() != null) {
                SemanticoUtils.adicionarErroSemantico(cmd.getStart(), "comando retorne nao permitido nesse escopo");
            }
        }

        return super.visitCorpo(ctx);
    }

    // Obtém o tipo a partir de uma string
    @Override
    public Object visitDeclaracao_constante(Declaracao_constanteContext ctx) {
        Tabela atual = escoposAninhados.getEscopo();
        if (atual.existe(ctx.IDENT().getText())) {
            SemanticoUtils.adicionarErroSemantico(ctx.start, "constante" + ctx.IDENT().getText()
                    + " ja declarado anteriormente");
        } else {
            Tabela.Tipos tipo = Tabela.Tipos.INT;
            switch (ctx.tipo_basico().getText()) {
                case "logico":
                    tipo = Tabela.Tipos.LOGICO;
                    break;
                case "literal":
                    tipo = Tabela.Tipos.CADEIA;
                    break;
                case "real":
                    tipo = Tabela.Tipos.REAL;
                    break;
                case "inteiro":
                    tipo = Tabela.Tipos.INT;
                    break;

            }
            atual.adiciona(ctx.IDENT().getText(), tipo);
        }

        return super.visitDeclaracao_constante(ctx);
    }
    // Verifica se a variavel ja existe, se não existe, ele adiciona a variavel e seu tipo à tabela
    @Override
    public Object visitDeclaracao_variavel(Declaracao_variavelContext ctx) {
        Tabela atual = escoposAninhados.getEscopo();
        Iterator<IdentificadorContext> iterator = ctx.variavel().identificador().iterator();

        while (iterator.hasNext()) {
            IdentificadorContext id = iterator.next();
            if (atual.existe(id.getText())) {
                SemanticoUtils.adicionarErroSemantico(id.start, "identificador " + id.getText()
                        + " ja declarado anteriormente");
            } else {
                Tabela.Tipos tipo = Tabela.Tipos.INT;
                switch (ctx.variavel().tipo().getText()) {
                    case "literal":
                        tipo = Tabela.Tipos.CADEIA;
                        break;
                    case "inteiro":
                        tipo = Tabela.Tipos.INT;
                        break;
                    case "real":
                        tipo = Tabela.Tipos.REAL;
                        break;
                    case "logico":
                        tipo = Tabela.Tipos.LOGICO;
                        break;
                }
                atual.adiciona(id.getText(), tipo);
            }
        }
        return super.visitDeclaracao_variavel(ctx);
    }
    // Verifica se uma atribuição é válida e verifica se a expressão da atribuição tem o mesmo tipo que a variável ou é compatível com ela, se não for, emite erro
    @Override
    public Object visitDeclaracao_global(Declaracao_globalContext ctx) {
        Tabela atual = escoposAninhados.getEscopo();
        if (atual.existe(ctx.IDENT().getText())) {
            SemanticoUtils.adicionarErroSemantico(ctx.start, ctx.IDENT().getText()
                    + " ja declarado anteriormente");
        } else {
            atual.adiciona(ctx.IDENT().getText(), Tabela.Tipos.TIPO);
        }
        return super.visitDeclaracao_global(ctx);
    }

    // Verifica se o tipo básico identificado é válido e verifica se o identificador foi declarado em algum escopo anterior, se sim, emite erro
    public Object visitTipo_basico_ident(Tipo_basico_identContext contextoTB) {
        if (contextoTB.IDENT() != null) {
            Iterator<Tabela> iterator = escoposAninhados.getPilha().iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                Tabela escopo = iterator.next();
                if (escopo.existe(contextoTB.IDENT().getText())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                SemanticoUtils.adicionarErroSemantico(contextoTB.start, "tipo " + contextoTB.IDENT().getText() + " nao declarado");
            }
        }
        return super.visitTipo_basico_ident(contextoTB);
    }

    // Verifica se a variavel foi declarada em algum escopo ligado anterior, se não, emite erro
    public Object visitIdentificador(IdentificadorContext contextoTB) {
        Iterator<Tabela> iterator = escoposAninhados.getPilha().iterator();
        boolean IdentDec = false;

        while (iterator.hasNext()) {
            Tabela escoposAninhados = iterator.next();
            if (escoposAninhados.existe(contextoTB.IDENT(0).getText())) {
                IdentDec = true;
                break;
            }
        }

        if (!IdentDec) {
            SemanticoUtils.adicionarErroSemantico(contextoTB.start,
                    "identificador " + contextoTB.IDENT(0).getText() + " nao declarado");
        }

        return super.visitIdentificador(contextoTB);
    }

    // Verifica se a atribuição é válida.Tb verifica se a expressão da atribuição tem o mesmo tipo que a variável ou é compatível com ela, se não for, emite erro
    @Override
    public Object visitCmdAtribuicao(CmdAtribuicaoContext ctx) {
        Tabela.Tipos Exptipo = SemanticoUtils.verificarTipo(escoposAninhados, ctx.expressao());
        boolean erro = false;
        String var = ctx.identificador().getText();
        if (Exptipo != Tabela.Tipos.INVALIDO) {
            Iterator<Tabela> iterator = escoposAninhados.getPilha().iterator();
            while (iterator.hasNext()) {
                Tabela escopo = iterator.next();
                if (escopo.existe(var)) {
                    Tabela.Tipos tipoVariavel = SemanticoUtils.verificarTipo(escoposAninhados, var);
                    Boolean varNumeric = tipoVariavel == Tabela.Tipos.REAL || tipoVariavel == Tabela.Tipos.INT;
                    Boolean expNumeric = Exptipo == Tabela.Tipos.REAL || Exptipo == Tabela.Tipos.INT;
                    if (!(varNumeric && expNumeric) && tipoVariavel != Exptipo
                            && Exptipo != Tabela.Tipos.INVALIDO) {
                        erro = true;
                        break;
                    }
                }
            }
        } else {
            erro = true;
        }

        if (erro)
            SemanticoUtils.adicionarErroSemantico(ctx.identificador().start,
                    "atribuicao nao compativel para " + var);

        return super.visitCmdAtribuicao(ctx);
    }

}
