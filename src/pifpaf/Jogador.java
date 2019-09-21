package pifpaf;

import java.util.ArrayList;
import java.util.Collections;

public class Jogador {
    private final String nome;
    private ArrayList<Carta> mao = new ArrayList<>();

    public Jogador(String nome) {this.nome = nome;}    

    public void setMao(ArrayList<Carta> mao) {this.mao = mao;}

    public ArrayList<Carta> getMao() {return mao;}

    public String getNome() {
        return nome;
    }
    
    public void mostrarCartas(){
        System.out.println("---------- CARTAS DE "+nome+" -----------");
        Collections.sort(mao);
        for (int i = 0 ; i < mao.size() ; i++) {
            System.out.println("("+i+")"+mao.get(i));
        }
    }
    
    public void remover(Carta c){
        Carta removivel = c;
        mao.remove(removivel);
    }
    
    
}
