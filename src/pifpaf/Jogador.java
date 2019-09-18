package pifpaf;

import java.util.ArrayList;
import java.util.Collections;

public class Jogador {
    private final String nome;
    private ArrayList<Carta> mao = new ArrayList<>();

    public Jogador(String nome) {this.nome = nome;}

    public void setMao(ArrayList<Carta> mao) {this.mao = mao;}

    public ArrayList<Carta> getMao() {return mao;}
    
    public void mostrarCartas(){
        System.out.println("---------- CARTAS DE "+nome+" -----------");
        Collections.sort(mao);
        for (int i = 0 ; i < mao.size() ; i++) {
            System.out.println("("+(i+1)+")"+mao.get(i));
        }
    }
}
