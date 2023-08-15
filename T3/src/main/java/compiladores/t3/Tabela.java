package compiladores.t3;

import java.util.HashMap;

public class Tabela {

    public enum Tipos{
        INT, REAL, CADEIA, LOGICO, INVALIDO, TIPO, IDENT
    }
    class EntradaTabelaDeSimbolos {
        String nome;
        Tipos tipo;

        private EntradaTabelaDeSimbolos (String nome, Tipos tipo){
            this.nome = nome;
            this.tipo = tipo;
        }

    }
    private HashMap<String, EntradaTabelaDeSimbolos > myTable;

    public Tabela(){
        myTable = new HashMap<>();
    }

    public boolean existe(String nome){
        return myTable.containsKey(nome);
    }

    public Tipos verifica(String nome){
        return myTable.get(nome).tipo;
    }

    public void adiciona(String nome, Tipos tipo){
        EntradaTabelaDeSimbolos  input = new EntradaTabelaDeSimbolos (nome, tipo);
        myTable.put(nome, input);
    }
}
