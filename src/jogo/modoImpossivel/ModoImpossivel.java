package jogo.modoImpossivel;
import static jogo.QuemVenceu.quemGanhou;
public class ModoImpossivel {

    public static void modoDificil(char[] tabuleiro, char simboloMaquina, char simboloJogador) {
        int melhorPontuacao = Integer.MIN_VALUE;
        int melhorPosicao = -1;

        for (int i = 0; i < 9; i++) {
            if (tabuleiro[i] == '-') {
                tabuleiro[i] = simboloMaquina;
                int pontuacao = minimax(tabuleiro, 0, false, simboloMaquina, simboloJogador);
                tabuleiro[i] = '-';
                if (pontuacao > melhorPontuacao) {
                    melhorPontuacao = pontuacao;
                    melhorPosicao = i;
                }
            }
        }

        if (melhorPosicao != -1) {
            tabuleiro[melhorPosicao] = simboloMaquina;
            System.out.println("Máquina jogou na posição: " + melhorPosicao);
        }
    }

    public static int minimax(char[] tab, int profundidade, boolean isMaximizando, char simboloMaquina, char simboloJogador) {
        Integer resultado = quemGanhou(tab, simboloJogador, simboloMaquina);

        if (resultado != null) {
            if (resultado == 1) {
                return 10 - profundidade;      // máquina venceu
            }
            if (resultado == 2){
                return profundidade - 10;      // jogador venceu
            }
            if (resultado == 0){
                return 0;                      // empate
            }
        }

        if (isMaximizando) {
            int melhorPontuacao = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (tab[i] == '-') {
                    tab[i] = simboloMaquina;
                    int pontuacao = minimax(tab, profundidade + 1, false, simboloMaquina, simboloJogador);
                    tab[i] = '-';
                    melhorPontuacao = Math.max(pontuacao, melhorPontuacao);
                }
            }
            return melhorPontuacao;
        } else {
            int melhorPontuacao = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (tab[i] == '-') {
                    tab[i] = simboloJogador;
                    int pontuacao = minimax(tab, profundidade + 1, true, simboloMaquina, simboloJogador);
                    tab[i] = '-';
                    melhorPontuacao = Math.min(pontuacao, melhorPontuacao);
                }
            }
            return melhorPontuacao;
        }
    }
}
