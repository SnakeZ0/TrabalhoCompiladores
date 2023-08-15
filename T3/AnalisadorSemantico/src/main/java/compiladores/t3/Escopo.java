package compiladores.t3;

import java.util.LinkedList;
import java.util.List;

public class Escopo {
    
    private LinkedList<Tabela> pilha; 

    public Escopo(){
        pilha = new LinkedList<>();
        criaEscopo();
    }

    //Cria um novo escopo
    public void criaEscopo(){
        pilha.push(new Tabela());
    }

    //Pega o escopo em que se esta atualmente
    public Tabela getEscopo(){
        return pilha.peek();
    }

    //Tira da pilha o escopo em que se esta
    public void dropEscopo(){
        pilha.pop();
    }

    //Pega a pilha com todas as tabelas
    public List<Tabela> getPilha(){
        return pilha;
    }

}
