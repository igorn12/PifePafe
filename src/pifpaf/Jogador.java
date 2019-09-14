package pifpaf;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    private ArrayList<Carta> mao = new ArrayList<>();

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void setMao(ArrayList<Carta> mao) {
        this.mao = mao;
    }

    public void mostrarCartas(){
        System.out.println("---------- CARTAS DE "+nome+" -----------");
        for (Carta i : mao) {
            System.out.println(i.toString());
        }
    }
}
