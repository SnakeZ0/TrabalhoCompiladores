package compiladores.t3;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import compiladores.t3.AnalisadorParser.Exp_aritmeticaContext;
import compiladores.t3.AnalisadorParser.ExpressaoContext;
import compiladores.t3.AnalisadorParser.FatorContext;
import compiladores.t3.AnalisadorParser.Fator_logicoContext;
import compiladores.t3.AnalisadorParser.ParcelaContext;
import compiladores.t3.AnalisadorParser.TermoContext;
import compiladores.t3.AnalisadorParser.Termo_logicoContext;
import java.util.Iterator;

public class SemanticoUtils {
    //Lista que armazena erros semânticos
    public static List<String> errosSemanticos = new ArrayList<>();

    //Adiciona um erro semântico à lista e informa a linha que foi encontrado, dado um token e a mensagem como parâmetros  
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo e considerando uma expressão
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.ExpressaoContext ctx) {
        Tabela.Tipos ret = null;
        Iterator<Termo_logicoContext> iterator = ctx.termo_logico().iterator();
        while (iterator.hasNext()) {
            Termo_logicoContext ta = iterator.next();
            Tabela.Tipos aux = verificarTipo(escopos, ta);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != Tabela.Tipos.INVALIDO) {
                ret = Tabela.Tipos.INVALIDO;
            }
        }
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo e considerando um termo lógico
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.Termo_logicoContext ctx) {
        Tabela.Tipos ret = null;
        Iterator<Fator_logicoContext> iterator = ctx.fator_logico().iterator();
        while (iterator.hasNext()) {
            Fator_logicoContext ta = iterator.next();
            Tabela.Tipos aux = verificarTipo(escopos, ta);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != Tabela.Tipos.INVALIDO) {
                ret = Tabela.Tipos.INVALIDO;
            }
        }
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando um fator lógico
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.Fator_logicoContext ctx) {
        return verificarTipo(escopos, ctx.parcela_logica());
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando uma parcela lógica
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.Parcela_logicaContext ctx) {
        Tabela.Tipos ret = null;
        if (ctx.exp_relacional() != null) {
            ret = verificarTipo(escopos, ctx.exp_relacional());
        } else {
            ret = Tabela.Tipos.LOGICO;
        }
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando uma expressão relacional
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.Exp_relacionalContext ctx) {
        Tabela.Tipos ret = null;
        if (ctx.op_relacional() != null) {
            Iterator<Exp_aritmeticaContext> iterator = ctx.exp_aritmetica().iterator();
            while (iterator.hasNext()) {
                Exp_aritmeticaContext ta = iterator.next();
                Tabela.Tipos aux = verificarTipo(escopos, ta);
                Boolean auxNumeric = aux == Tabela.Tipos.REAL || aux == Tabela.Tipos.INT;
                Boolean retNumeric = ret == Tabela.Tipos.REAL || ret == Tabela.Tipos.INT;
                if (ret == null) {
                    ret = aux;
                } else if (!(auxNumeric && retNumeric) && aux != ret) {
                    ret = Tabela.Tipos.INVALIDO;
                }
            }

            if (ret != Tabela.Tipos.INVALIDO) {
                ret = Tabela.Tipos.LOGICO;
            }
        } else {
            ret = verificarTipo(escopos, ctx.exp_aritmetica(0));
        }
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando uma expressão aritmética
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.Exp_aritmeticaContext ctx) {
        Tabela.Tipos ret = null;
        Iterator<TermoContext> iterator = ctx.termo().iterator();
        while (iterator.hasNext()) {
            TermoContext ta = iterator.next();
            Tabela.Tipos aux = verificarTipo(escopos, ta);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != Tabela.Tipos.INVALIDO) {
                ret = Tabela.Tipos.INVALIDO;
            }
        }
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando um termo
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.TermoContext ctx) {
        Tabela.Tipos ret = null;

        Iterator<FatorContext> iterator = ctx.fator().iterator();
        while (iterator.hasNext()) {
            FatorContext fa = iterator.next();
            Tabela.Tipos aux = verificarTipo(escopos, fa);
            Boolean auxNumeric = aux == Tabela.Tipos.REAL || aux == Tabela.Tipos.INT;
            Boolean retNumeric = ret == Tabela.Tipos.REAL || ret == Tabela.Tipos.INT;
            if (ret == null) {
                ret = aux;
            } else if (!(auxNumeric && retNumeric) && aux != ret) {
                ret = Tabela.Tipos.INVALIDO;
            }
        }
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando um fator
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.FatorContext ctx) {
        Tabela.Tipos ret = null;

        Iterator<ParcelaContext> iterator = ctx.parcela().iterator();
        while (iterator.hasNext()) {
            ParcelaContext fa = iterator.next();
            Tabela.Tipos aux = verificarTipo(escopos, fa);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != Tabela.Tipos.INVALIDO) {
                ret = Tabela.Tipos.INVALIDO;
            }
        }
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando uma parcela
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.ParcelaContext ctx) {
        Tabela.Tipos ret = Tabela.Tipos.INVALIDO;

        if (ctx.parcela_nao_unario() != null) {
            ret = verificarTipo(escopos, ctx.parcela_nao_unario());
        } else {
            ret = verificarTipo(escopos, ctx.parcela_unario());
        }
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando uma parcela não unária
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.Parcela_nao_unarioContext ctx) {
        if (ctx.identificador() != null) {
            return verificarTipo(escopos, ctx.identificador());
        }
        return Tabela.Tipos.CADEIA;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando um identificador
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.IdentificadorContext ctx) {
        String nomeVar = "";
        Tabela.Tipos ret = Tabela.Tipos.INVALIDO;
        for (int i = 0; i < ctx.IDENT().size(); i++) {
            nomeVar += ctx.IDENT(i).getText();
            if (i != ctx.IDENT().size() - 1) {
                nomeVar += ".";
            }
        }
        Iterator<Tabela> iterator = escopos.getPilha().iterator();
        while (iterator.hasNext()) {
        Tabela tabela = iterator.next();
        if (tabela.existe(nomeVar)) {
            ret = verificarTipo(escopos, nomeVar);
        }
        }
        System.out.println(nomeVar);
        return ret;
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando uma parcela unária
    public static Tabela.Tipos verificarTipo(Escopo escopos, AnalisadorParser.Parcela_unarioContext ctx) {
        if (ctx.NUM_INT() != null) {
            return Tabela.Tipos.INT;
        }
        if (ctx.NUM_REAL() != null) {
            return Tabela.Tipos.REAL;
        }
        if (ctx.identificador() != null) {
            return verificarTipo(escopos, ctx.identificador());
        }
        if (ctx.IDENT() != null) {
            Tabela.Tipos ret = null;
            ret = verificarTipo(escopos, ctx.IDENT().getText());
            Iterator<ExpressaoContext> iterator = ctx.expressao().iterator();
            while (iterator.hasNext()) {
                ExpressaoContext fa = iterator.next();
                Tabela.Tipos aux = verificarTipo(escopos, fa);
                if (ret == null) {
                    ret = aux;
                } else if (ret != aux && aux != Tabela.Tipos.INVALIDO) {
                    ret = Tabela.Tipos.INVALIDO;
                }
            }
            return ret;
        } else {
            Tabela.Tipos ret = null;
            Iterator<ExpressaoContext> iterator = ctx.expressao().iterator();
            while (iterator.hasNext()) {
                ExpressaoContext fa = iterator.next();
                Tabela.Tipos aux = verificarTipo(escopos, fa);
                if (ret == null) {
                    ret = aux;
                } else if (ret != aux && aux != Tabela.Tipos.INVALIDO) {
                    ret = Tabela.Tipos.INVALIDO;
                }
            }
            return ret;
        }
    }

    //Checa o tipo de um símbolo presente em uma tabela de símbolos, a partir do escopo considerando uma string
    public static Tabela.Tipos verificarTipo(Escopo escopos, String nomeVar) {
        Tabela.Tipos type = null;
        Iterator<Tabela> iterator = escopos.getPilha().iterator();
        while (iterator.hasNext()) {
            Tabela tabela = iterator.next();
            type = tabela.verifica(nomeVar);
        }
        return type;
    }
}
