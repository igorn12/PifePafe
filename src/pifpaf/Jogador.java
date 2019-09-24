package pifpaf;

import java.util.ArrayList;
import java.util.Collections;

public class Jogador {
    private final String nome;
    private ArrayList<Carta> mao = new ArrayList<>();
    private ArrayList<Carta> vencer = new ArrayList<>();

    public Jogador(String nome) {this.nome = nome;}    

    public void setMao(ArrayList<Carta> mao) {this.mao = mao;}

    public ArrayList<Carta> getVencer() {
        return vencer;
    }

    public void setVencer(ArrayList<Carta> vencer) {
        this.vencer = vencer;
    }

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
    
    public void verificaJogos(ArrayList<Carta> mao){
        for (int a = 0 ; a < mao.size() ; a++) {
            int b = 1;
            int c = 2;
            if(mao.get(a).getFace().equals(mao.get(b).getFace())){
                if(mao.get(b).getFace().equals(mao.get(c).getFace())){
                    if(mao.get(c).getFace().equals(mao.get(a).getFace())){
                        if(!mao.get(a).getNaipe().equals(mao.get(b).getNaipe())){
                            if(!mao.get(b).getNaipe().equals(mao.get(c).getNaipe())){
                                if(!mao.get(c).getNaipe().equals(mao.get(a).getNaipe())){
                                    vencer.add(mao.get(a));
                                    vencer.add(mao.get(b));
                                    vencer.add(mao.get(c));
                                    removeCartas();
                                    System.out.println("Fez uma trinca !");
                                }
                            }
                        }
                    }
                }
            }
            b++;
            c++;
        }

        for (int a = 0 ; a < mao.size() ; a++) {
            int b = 1;
            int c = 2;
            if(mao.get(a).getCont() == (mao.get(b).getCont() - 1)){
                if(mao.get(b).getCont() == (mao.get(c).getCont() - 1)){
                    if(mao.get(c).getCont() == (mao.get(c).getCont() + 2)){
                        if(mao.get(a).getNaipe().equals(mao.get(b).getNaipe())){
                            if(mao.get(b).getNaipe().equals(mao.get(c).getNaipe())){
                                if(mao.get(c).getNaipe().equals(mao.get(a).getNaipe())){
                                    vencer.add(mao.get(a));
                                    vencer.add(mao.get(b));
                                    vencer.add(mao.get(c));
                                    removeCartas();
                                    System.out.println("Fez uma sequencia !");
                                }
                            }
                        }
                    }
                }
            }
            b++;
            c++;
        }
    }
    
    public void removeCartas(){
        for (int i = 0; i < vencer.size(); i++) {
            this.mao.remove(vencer.get(i));
        }
    }
    
    public void mostrarVencedor(){
        if(vencer.size() == 9){
            System.out.println(nome+"\n Venceu com: ");
            for (Carta v : vencer) {
            System.out.println(v.toString());
            }
        }else{
            System.out.println("Não venceu ainda !!");
        }
    }
}
