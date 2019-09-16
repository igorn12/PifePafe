package pifpaf;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private final Scanner input = new Scanner(System.in);
    private final Baralho baralho = new Baralho();
    private final ArrayList<Jogador> jogadores = new ArrayList<>();

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
        baralho.iniciarBolo();
        baralho.mostrarBolo();
    }
    public void iniciarPifePafe(){
        for(Jogador j : jogadores){
            j.setMao(baralho.puxarDoBolo(j.getMao()));
            j.mostrarCartas();
            break;
        }
        System.out.println("jogador, escolha uma carta para descartar: ");
        int opcao = input.nextInt();
        do {
            baralho.mostrarBolo();
        } while (opcao != 0);
        
    }
}
