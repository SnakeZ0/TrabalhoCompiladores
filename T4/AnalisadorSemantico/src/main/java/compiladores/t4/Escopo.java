package compiladores.t4;

import java.util.LinkedList;
import java.util.List;

public class Escopo {
    private LinkedList<Tabela> pilha; //empilhando tabelas

    public Escopo(Tabela.Tipos returnType){
        pilha = new LinkedList<>();
        create(returnType);
    }

    public void create(Tabela.Tipos returnType){
        pilha.push(new Tabela(returnType));
    }

    public Tabela getEscopo(){
        return pilha.peek();
    }

    public List<Tabela> getPilha(){
        return pilha;
    }

    public void dropEscopo(){
        pilha.pop();
    }

    public boolean identExists(String name){
        for(Tabela escopo : pilha) {
            if(!escopo.existe(name)) {
                return true;
            }
        }
        return false;
    }
}
