package pifpaf;

public class PifPaf {
    public static void main(String[] args) {
        Jogo j = new Jogo();
        j.iniciarJogo();
        j.distribuirCartas(9);
        j.mostrarCartas();
        j.iniciarPifePafe();
    }
}
