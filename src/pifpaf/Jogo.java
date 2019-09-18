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
        int indice = 0;
        for(Jogador j : jogadores){
            j.setMao(baralho.puxarDoBolo(j.getMao()));
            j.mostrarCartas();
            break;
        }
        System.out.println("jogador, escolha uma carta para descartar: ");
        indice = input.nextInt();
        baralho.iniciarLixeira(jogadores.get(0).getMao().get(indice-1));
        
        int opcao;
        do {
            System.out.println("----- MENU DO JOGO -----");
            System.out.println("\n1 - puxar do bolozn2 - puxar da lixeira\n0 - sair");
            System.out.println("Jogador informe sua jogada: ");
            opcao = input.nextInt();
            for (int i = 0 ; i < jogadores.size(); i++) {
                baralho.mostrarBolo();
                baralho.mostrarLixeira();
                switch(opcao){
                case 1:
                    jogadores.get(i).setMao(baralho.puxarDoBolo(jogadores.get(i).getMao()));
                    jogadores.get(i).mostrarCartas();
                    break;
                case 2:
                    jogadores.get(i).setMao(baralho.puxarDaLixeira(jogadores.get(i).getMao()));
                    jogadores.get(i).mostrarCartas();
                    break;
                default:
                    System.out.println("Numero inválido;");
                    break;
            }
            }
        } while (opcao != 0);
    }
}
