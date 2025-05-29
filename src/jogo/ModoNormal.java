package jogo;

import java.util.Scanner;

import static ferramentas.ImprimeTabuleiro.imprimeTabuleiro;
import static ferramentas.Maquina.maquinaJogada;
import static ferramentas.Ranking.registrarVitoria;
import static jogo.JogadasUser.ondeJoga;
import static jogo.JogadasUser.validaJogada;
import static jogo.QuemJoga.quemJoga;
import static jogo.QuemVenceu.quemGanhou;
import static jogo.Usuario.escolhaSimbulo;
import static jogo.Usuario.setarJogador;

public class ModoNormal {
    public static void modoNormal() {
        Scanner sc = new Scanner(System.in);
        char[] tabuleiro = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};

        whileAlto:
        while (true) {

            whileMedio:
            while (true) {
                String nomeJogador = setarJogador();
                char simboloJogador = escolhaSimbulo().charAt(0);
                char simboloMaquina = (simboloJogador == 'X') ? 'O' : 'X';
                int quemJoga = quemJoga();

                while (true) {
                    int quemJogara = quemJoga();

                    if (quemJogara == 1) {
                        imprimeTabuleiro(tabuleiro);
                        ondeJoga(tabuleiro, String.valueOf(simboloJogador));
                    } else if (quemJogara == 0) {
                        int jogada;
                        boolean isValido = false;
                        while (!isValido) {
                            jogada = maquinaJogada(tabuleiro);
                            isValido = validaJogada(jogada, tabuleiro);
                            if (isValido) {
                                tabuleiro[jogada] = simboloMaquina;
                            }
                        }
                    }
                    Integer result = quemGanhou(tabuleiro, simboloJogador, simboloMaquina);

                    if (result != null) {
                        if (result == 1) {
                            System.out.println("maquina venceu");
                            registrarVitoria(1);
                            break whileMedio;
                        }
                        if (result == 2) {
                            System.out.println("jogador ganhou");
                            registrarVitoria(2);
                            break whileMedio;
                        }
                        if (result == 0) {
                            System.out.println("Empate");
                            registrarVitoria(0);
                            break whileMedio;
                        }
                    }
                }
            }

            System.out.print("Deseja jogar novamente(S/N)");
            String escolha = sc.nextLine();
            if (escolha.toUpperCase().charAt(0) == 'N') {
                break whileAlto;
            }
        }
    }

}
