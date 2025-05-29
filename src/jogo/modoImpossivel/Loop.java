package jogo.modoImpossivel;

import static ferramentas.ImprimeTabuleiro.imprimeTabuleiro;
import static ferramentas.Ranking.registrarVitoria;
import static jogo.JogadasUser.ondeJoga;
import static jogo.Menu.jogarNovamente;
import static jogo.QuemVenceu.quemGanhou;
import static jogo.Usuario.escolhaSimbulo;
import static jogo.Usuario.setarJogador;
import static jogo.modoImpossivel.ModoImpossivel.*;
import static jogo.QuemJoga.quemJoga;

public class Loop {
    public static void jogarModoDificil() {
        String nomeUser = setarJogador();

        do {
            char[] tabuleiro = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
            String simboloJogador = escolhaSimbulo();
            char simboloJ = simboloJogador.charAt(0);
            char simboloMaquina = (simboloJ == 'X') ? 'O' : 'X';

            int vez = quemJoga(); // 0 = máquina, 1 = jogador

            while (true) {
                imprimeTabuleiro(tabuleiro);

                if (vez == 1) {
                    System.out.println("Sua vez de jogar:");
                    ondeJoga(tabuleiro, simboloJogador);
                } else {
                    System.out.println("Vez da máquina:");
                    modoDificil(tabuleiro, simboloMaquina, simboloJ);
                }

                Integer resultado = quemGanhou(tabuleiro, simboloJ, simboloMaquina);
                if (resultado != null) {
                    imprimeTabuleiro(tabuleiro);
                    if (resultado == 2) {
                        System.out.println("Você venceu!");
                        registrarVitoria(2);
                    } else if (resultado == 1) {
                        System.out.println("A máquina venceu!");
                        registrarVitoria(1);
                    } else {
                        System.out.println("Empate!");
                        registrarVitoria(0);
                    }
                    break;
                }

                vez = 1 - vez;
            }
        } while (jogarNovamente() == 1);
    }
}
