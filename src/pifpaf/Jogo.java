package pifpaf;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private Scanner input = new Scanner(System.in);
    private Baralho baralho = new Baralho();
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public void iniciarJogo() {
        baralho.mostrarBaralho();
        baralho.embaralhar();
        baralho.mostrarBaralho();

        for (int i = 0 ; i < 2 ; i++){
            System.out.println("Jogador "+(i+1)+", informe seu nome: ");
            jogadores.add(new Jogador(input.next()));
        }
    }
    public void distribuirCartas(int qtdCartas){
        for (Jogador j : jogadores){
            System.out.println("--- DISTRIBUINDO CARTAS ---");
            j.setMao(baralho.distribuirCartas(qtdCartas));
        }
    }
    public void mostrarCartas(){
        for (Jogador j : jogadores){
            j.mostrarCartas();
        }
    }
}