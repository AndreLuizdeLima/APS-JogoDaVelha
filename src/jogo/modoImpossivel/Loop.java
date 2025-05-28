package jogo.modoImpossivel;
import jogo.Usuario;

import static ferramentas.ImprimeTabuleiro.imprimeTabuleiro;
import static jogo.JogadasUser.ondeJoga;
import static jogo.Usuario.escolhaSimbulo;
import static jogo.modoImpossivel.ModoImpossivel.*;

public class Loop {
    public static void jogarModoDificil(char[] tabuleiro) {
        String simboloJogador = escolhaSimbulo(); // ex: "X" ou "O"
        char simboloJ = simboloJogador.charAt(0);
        char simboloMaquina = (simboloJ == 'X') ? 'O' : 'X';

        while (true) {
            imprimeTabuleiro(tabuleiro);

            System.out.println("Sua vez de jogar:");
            ondeJoga(tabuleiro, simboloJogador);

            if (verificaVencedor(tabuleiro, simboloJ)) {
                imprimeTabuleiro(tabuleiro);
                System.out.println("Você venceu!");
                break;
            }

            if (tabuleiroCheio(tabuleiro)) {
                imprimeTabuleiro(tabuleiro);
                System.out.println("Empate!");
                break;
            }

            System.out.println("Vez da máquina:");
            modoDificil(tabuleiro, simboloMaquina, simboloJ);

            if (verificaVencedor(tabuleiro, simboloMaquina)) {
                imprimeTabuleiro(tabuleiro);
                System.out.println("A máquina venceu!");
                break;
            }

            if (tabuleiroCheio(tabuleiro)) {
                imprimeTabuleiro(tabuleiro);
                System.out.println("Empate!");
                break;
            }
        }
    }
}
