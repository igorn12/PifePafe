package pifpaf;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {
    private Random aleatorio;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private ArrayList<Carta> lixeira = new ArrayList<>();
    private ArrayList<Carta> maco = new ArrayList<>();
    private int cont=0, cont2=0;

    public Baralho() {
        this.cartas = cartas;

        String[] naipe = {"Paus", "Copas", "Espadas", "Ouros"};
        String[] face = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (int i = 0; i < naipe.length; i++){
            for (int j = 0; j < face.length; j++){
                cartas.add(new Carta(face[j], naipe[i]));
            }
        }
    }

    public void setBolo(ArrayList<Carta> lixeira) {
        this.lixeira = lixeira;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void setMaco(ArrayList<Carta> maco) {
        this.maco = maco;
    }

    public void mostrarBaralho(){
        System.out.println("----------------- MOSTRANDO CARTAS ---------------");
        for(Carta i : cartas){
            System.out.println(i.toString());
        }
    }

    public void embaralhar(){
        aleatorio = new Random();
        System.out.println("EMBARALHANDO");
        for (int i = 0 ; i < cartas.size(); i++){
            Carta aux;
            int x = aleatorio.nextInt(cartas.size());
            aux = cartas.get(i);
            cartas.set(i, cartas.get(x));
            cartas.set(x,aux);
        }
    }
    public ArrayList<Carta> distribuirCartas(int qtdCartas){
        ArrayList<Carta> maoJogador = new ArrayList<>();
        for (int i = 0 ; i < qtdCartas ; i++){
            maoJogador.add(cartas.get(cont));
            cont++;
        }
        return maoJogador;
    }
        
    public void iniciarBolo(){
        int num = cont;
        for (int i = cont; i < cartas.size(); i++) {
            maco.add(cartas.get(num));
            num++;
        }
    }
        
    public void mostrarBolo(){System.out.println("\nBOLO : "+maco.get(0)+"\n");}
    
    public ArrayList<Carta> puxarDoBolo(ArrayList<Carta> mao){
        ArrayList<Carta> carta = new ArrayList<>(mao);
        carta.add(maco.get(0));
        maco.remove(0);
        return carta;
    }
    
    public void mostrarLixeira(){
        if(!lixeira.isEmpty())
            System.out.println("Lixeira : "+lixeira.get(lixeira.size()-1));   
    }
    public ArrayList<Carta> puxarDaLixeira(ArrayList<Carta> lixo){
        ArrayList<Carta> carta = new ArrayList<>(lixo);
        if(!lixeira.isEmpty())
            carta.add(lixeira.get(lixeira.size()-1));
            lixeira.remove(0);
        return carta;
    }
}
