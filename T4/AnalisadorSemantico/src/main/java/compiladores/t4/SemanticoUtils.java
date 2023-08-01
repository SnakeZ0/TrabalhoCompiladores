package compiladores.t4;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import compiladores.t4.AnalisadorParser.Exp_aritmeticaContext;
import compiladores.t4.AnalisadorParser.ExpressaoContext;
import compiladores.t4.AnalisadorParser.FatorContext;
import compiladores.t4.AnalisadorParser.Fator_logicoContext;
import compiladores.t4.AnalisadorParser.ParcelaContext;
import compiladores.t4.AnalisadorParser.TermoContext;
import compiladores.t4.AnalisadorParser.Termo_logicoContext;

public class SemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();//onde os erros semanticos seram armazenados

    public static void adicionarErroSemantico(Token t, String mensagem) {// adiciona os erros a lista
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.ExpressaoContext ctx) {// verifica o tipo da expressão lógica
        Tabela.Tipos retTipo = null;
        int i = 0;
        while (i < ctx.termo_logico().size()) {
            Termo_logicoContext tl = ctx.termo_logico(i);
            Tabela.Tipos aux = verTipo(escopos, tl);
            if (retTipo == null) {
                retTipo = aux;
            } else if (retTipo != aux && aux != Tabela.Tipos.INVALIDO) {
                retTipo = Tabela.Tipos.INVALIDO;
            }
            i++;
        }
        return retTipo;
    }

    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.Termo_logicoContext ctx) {// verifica o tipo de um termo da expressão lógica
        Tabela.Tipos retTipo = null;
        int i = 0;
        while (i < ctx.fator_logico().size()) {
            Fator_logicoContext tl = ctx.fator_logico(i);
            Tabela.Tipos aux = verTipo(escopos, tl);
            if (retTipo == null) {
                retTipo = aux;
            } else if (retTipo != aux && aux != Tabela.Tipos.INVALIDO) {
                retTipo = Tabela.Tipos.INVALIDO;
            }
            i++;
        }
        return retTipo;
    }

    // Verifica o tipo de uma fator logico
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.Fator_logicoContext ctx) {
        return verTipo(escopos, ctx.parcela_logica());
    }

    //verifica o tipo de uma parcela logica
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.Parcela_logicaContext ctx) {
        Tabela.Tipos retTipo = null;
        if (ctx.exp_relacional() != null) {
            retTipo = verTipo(escopos, ctx.exp_relacional());
        } else {
            retTipo = Tabela.Tipos.LOGICO;
        }

        return retTipo;
    }

    //Verifica o tipo de uma expressão relacional 
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.Exp_relacionalContext ctx) {
        Tabela.Tipos retTipo = null;
        if (ctx.op_relacional() != null) {
            int i = 0;
            while (i < ctx.exp_aritmetica().size()) {
                Exp_aritmeticaContext ta = ctx.exp_aritmetica(i);
                Tabela.Tipos aux = verTipo(escopos, ta);
                // da pra relacionar real e inteiro
                Boolean auxNumeric = aux == Tabela.Tipos.REAL || aux == Tabela.Tipos.INT;
                Boolean retNumeric = retTipo == Tabela.Tipos.REAL || retTipo == Tabela.Tipos.INT;
                if (retTipo == null) {
                    retTipo = aux;
                } else if (!(auxNumeric && retNumeric) && aux != retTipo) {
                    retTipo = Tabela.Tipos.INVALIDO;
                }
                i++;
            }
            if (retTipo != Tabela.Tipos.INVALIDO) {
                retTipo = Tabela.Tipos.LOGICO;
            }
        } else {
            retTipo = verTipo(escopos, ctx.exp_aritmetica(0));
        }

        return retTipo;
    }

    // Verifica o tipo de uma expressão aritmética
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.Exp_aritmeticaContext ctx) {
        Tabela.Tipos retTipo = null;
        int i = 0;
        while (i < ctx.termo().size()) {
            TermoContext ta = ctx.termo(i);
            Tabela.Tipos aux = verTipo(escopos, ta);
            if (retTipo == null) {
                retTipo = aux;
            } else if (retTipo != aux && aux != Tabela.Tipos.INVALIDO) {
                retTipo = Tabela.Tipos.INVALIDO;
            }
            i++;
        }

        return retTipo;
    }

    // Verifica o tipo de um termo em uma expressão
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.TermoContext ctx) {
        Tabela.Tipos retTipo = null;

        int i = 0;
        while (i < ctx.fator().size()) {
            FatorContext fa = ctx.fator(i);
            Tabela.Tipos aux = verTipo(escopos, fa);
            Boolean auxNumeric = aux == Tabela.Tipos.REAL || aux == Tabela.Tipos.INT; 
            Boolean retNumeric = retTipo == Tabela.Tipos.REAL || retTipo == Tabela.Tipos.INT;
            if (retTipo == null) {
                retTipo = aux;
            } else if (!(auxNumeric && retNumeric) && aux != retTipo) {
                retTipo = Tabela.Tipos.INVALIDO;
            }
            i++;
        }
        return retTipo;
    }

    //verifica o tipo de um fator
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.FatorContext ctx) {
        Tabela.Tipos retTipo = null;
    
        int i = 0;
        while (i < ctx.parcela().size()) {
            ParcelaContext fa = ctx.parcela(i);
            Tabela.Tipos aux = verTipo(escopos, fa);
            if (retTipo == null) {
                retTipo = aux;
            } else if (retTipo != aux && aux != Tabela.Tipos.INVALIDO) {
                retTipo = Tabela.Tipos.INVALIDO;
            }
            i++;
        }
        return retTipo;
    }
    

    //verifica o tipo de uma parcela,sendo q ela pode ser unaria ou não unaria
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.ParcelaContext ctx) {
        Tabela.Tipos retTipo = Tabela.Tipos.INVALIDO;

        if (ctx.parcela_nao_unario() != null) {
            retTipo = verTipo(escopos, ctx.parcela_nao_unario());
        } else {
            retTipo = verTipo(escopos, ctx.parcela_unario());
        }
        return retTipo;
    }

    //parcela não unaria
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.Parcela_nao_unarioContext ctx) {
        if (ctx.identificador() != null) {
            return verTipo(escopos, ctx.identificador());
        }
        return Tabela.Tipos.CADEIA;
    }

    // verifica o tipo do identificador não unario
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.IdentificadorContext ctx) {
        String Var = "";
        Tabela.Tipos retTipo = Tabela.Tipos.INVALIDO;
        int i = 0;
        while (i < ctx.IDENT().size()) {
            Var += ctx.IDENT(i).getText();
            if (i != ctx.IDENT().size() - 1) {
                Var += ".";
            }
            i++;
        }
        for (Tabela tabela : escopos.getPilha()) {
            if (tabela.existe(Var)) {
                retTipo = verTipo(escopos, Var);
            }
        }
        return retTipo;
    }

    //parecela unaria
    public static Tabela.Tipos verTipo(Escopo escopos, AnalisadorParser.Parcela_unarioContext ctx) {
        if (ctx.identificador() != null) {
            return verTipo(escopos, ctx.identificador());
        }
        if (ctx.NUM_REAL() != null) {
            return Tabela.Tipos.REAL;
        }
        if (ctx.NUM_INT() != null) {
            return Tabela.Tipos.INT;
        }
        if (ctx.IDENT() != null) {
            return verTipo(escopos, ctx.IDENT().getText());
        } else {
            Tabela.Tipos retTipo = null;
            int i = 0;
            while (i < ctx.expressao().size()) {
                ExpressaoContext fa = ctx.expressao(i);
                Tabela.Tipos aux = verTipo(escopos, fa);
                if (retTipo == null) {
                    retTipo = aux;
                } else if (retTipo != aux && aux != Tabela.Tipos.INVALIDO) {
                    retTipo = Tabela.Tipos.INVALIDO;
                }
                i++;
            }
            return retTipo;
        }
    }

    // verifica se a variavel existe usando uma string
    public static Tabela.Tipos verTipo(Escopo escopos, String Var) {
        Tabela.Tipos tipo = Tabela.Tipos.INVALIDO;
        int i = 0;
        while (i < escopos.getPilha().size()) {
            Tabela tabela = escopos.getPilha().get(i);
            if (tabela.existe(Var)) {
                return tabela.verifica(Var);
            }
            i++;
        }

        return tipo;
    }

    // transforma a string em um tipo da tabela de simbolos
    public static Tabela.Tipos getTipo(String val) {
        Tabela.Tipos tipo = null;
        switch (val) {
            case "real":
                tipo = Tabela.Tipos.REAL;
                break;
            case "inteiro":
                tipo = Tabela.Tipos.INT;
                break;
            case "logico":
                tipo = Tabela.Tipos.LOGICO;
                break;
            case "literal":
                tipo = Tabela.Tipos.CADEIA;
                break;
            default:
                break;
        }
        return tipo;
    }

}
