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
        jogadores.stream().map((j) -> {
            System.out.println("--- DISTRIBUINDO CARTAS ---");
            return j;
        }).forEachOrdered((j) -> {
            j.setMao(baralho.distribuirCartas(qtdCartas));
        });
    }
    
    public void mostrarCartas(){
        jogadores.forEach((j) -> {
            j.mostrarCartas();
        });
        baralho.iniciarBolo();
    }
    
    public void iniciarPifePafe(){
        int indice;
        int opcao = 1;
        
        do {
            for (Jogador j : jogadores) {
                j.mostrarCartas();
                baralho.mostrarBolo();
                baralho.mostrarLixeira();
                System.out.println("\n1 - puxar do bolo\n2 - puxar da lixeira\n0 - sair");
                System.out.println("Jogador "+j.getNome()+", informe sua jogada: ");
                opcao = input.nextInt();
                
                switch(opcao){
                case 1:
                    j.setMao(baralho.puxarDoBolo(j.getMao()));
                    j.verificaJogos();
                    j.mostrarCartas();
                    System.out.println("jogador "+j.getNome()+", escolha uma carta para descartar: ");
                    indice = input.nextInt();
                    baralho.lixeira(j.getMao().get(indice));
                    j.remover(j.getMao().get(indice));
                    break;
                
                case 2:
                    j.setMao(baralho.puxarDaLixeira(j.getMao()));
                    j.verificaJogos();
                    j.mostrarCartas();
                    System.out.println("jogador "+j.getNome()+", escolha uma carta para descartar: ");
                    indice = input.nextInt();
                    baralho.lixeira(j.getMao().get(indice));
                    j.remover(j.getMao().get(indice));
                    break;
                
                default:
                    System.out.println("Numero inválido;");
                    break;
                }
            }
        } while (opcao != 0);
    }
}
