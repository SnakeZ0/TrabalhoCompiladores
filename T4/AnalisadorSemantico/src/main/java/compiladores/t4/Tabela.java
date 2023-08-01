package compiladores.t4;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class Tabela {
    public Tabela.Tipos returnType;
    public enum Tipos{
        INT, REAL, CADEIA, LOGICO, INVALIDO, REG, VOID
    }

    public enum Structure{
        VAR, CONST, PROC, FUNC, TIPO
    }

    class EntradaTabelaDeSimbolos{
        String name;
        Tipos tipo;
        Structure structure;

        public EntradaTabelaDeSimbolos(String name, Tipos tipo, Structure structure){
            this.name = name;
            this.tipo = tipo;
            this.structure = structure;

        }

    }
    private HashMap<String, EntradaTabelaDeSimbolos> Mtabela;
    private HashMap<String, ArrayList<EntradaTabelaDeSimbolos>> Ttabela;

    public Tabela(Tabela.Tipos returnType){
        Mtabela = new HashMap<>();
        Ttabela = new HashMap<>();
        this.returnType = returnType;
    }

    public void adiciona(String name, Tipos tipo, Structure structure){
        EntradaTabelaDeSimbolos input = new EntradaTabelaDeSimbolos(name, tipo, structure);
        Mtabela.put(name, input);
    }

    public void adiciona(EntradaTabelaDeSimbolos input){
        Mtabela.put(input.name, input);

    }

    public void adiciona(String tipoName, EntradaTabelaDeSimbolos input){
        if(Ttabela.containsKey(tipoName)){
            Ttabela.get(tipoName).add(input);
        }else{
            ArrayList<EntradaTabelaDeSimbolos> list = new ArrayList<>();
            list.add(input);
            Ttabela.put(tipoName, list);
        }
    }

    public Tipos verifica(String name){
        return Mtabela.get(name).tipo;
    }

    public boolean existe(String name){
        return Mtabela.containsKey(name); 
    }

    public ArrayList<EntradaTabelaDeSimbolos> getTypeProperties(String name){
        return Ttabela.get(name);
    }
}
