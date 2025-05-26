import static ferramentas.ImprimeTabuleiro.imprimeTabuleiro;
import static jogo.Usuario.escolhaSimbulo;
import static jogo.Usuario.setarJogador;

public class Main {
    public static void main(String[] args) {
        char[] tabuleiro = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        setarJogador();
        escolhaSimbulo();
        imprimeTabuleiro(tabuleiro);
    }
}