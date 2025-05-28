package jogo.modoImpossivel;

public class ModoImpossivel {

    public static void modoDificil(char[] tabuleiro, char simboloMaquina, char simboloJogador) {
        int melhorPontuacao = Integer.MIN_VALUE;
        int melhorPosicao = -1;

        for (int i = 0; i < 9; i++) {
            if (tabuleiro[i] == '-') {  // <-- aqui, verifica se está vazia
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
        if (verificaVencedor(tab, simboloMaquina)) return 10 - profundidade;
        if (verificaVencedor(tab, simboloJogador)) return profundidade - 10;
        if (tabuleiroCheio(tab)) return 0;

        if (isMaximizando) {
            int melhorPontuacao = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (tab[i] == '-') {  // <-- casa vazia
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
                if (tab[i] == '-') {  // <-- casa vazia
                    tab[i] = simboloJogador;
                    int pontuacao = minimax(tab, profundidade + 1, true, simboloMaquina, simboloJogador);
                    tab[i] = '-';
                    melhorPontuacao = Math.min(pontuacao, melhorPontuacao);
                }
            }
            return melhorPontuacao;
        }
    }

    public static boolean verificaVencedor(char[] tab, char jogador) {
        int[][] vitorias = {
                {0,1,2}, {3,4,5}, {6,7,8},   // linhas
                {0,3,6}, {1,4,7}, {2,5,8},   // colunas
                {0,4,8}, {2,4,6}             // diagonais
        };

        for (int[] linha : vitorias) {
            if (tab[linha[0]] == jogador && tab[linha[1]] == jogador && tab[linha[2]] == jogador) {
                return true;
            }
        }
        return false;
    }

    public static boolean tabuleiroCheio(char[] tab) {
        for (char c : tab) {
            if (c == '-') {  // <-- casa vazia
                return false;
            }
        }
        return true;
    }
}
