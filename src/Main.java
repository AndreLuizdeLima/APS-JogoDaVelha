import static ferramentas.ImprimeTabuleiro.imprimeTabuleiro;
import static jogo.QuemJoga.quemJoga;
import static jogo.Usuario.escolhaSimbulo;
import static jogo.Usuario.setarJogador;

public class Main {
    public static void main(String[] args) {
//        char[] tabuleiro = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
//        setarJogador();
//        escolhaSimbulo();
//        imprimeTabuleiro(tabuleiro);


        for(int i = 1; i<10; i++){
            System.out.println("quem joga: " + quemJoga());
        }
    }
}