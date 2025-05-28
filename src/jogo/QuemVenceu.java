package jogo;

public class QuemVenceu {

    // simbolo X ou O
    // simbolo é sempre o jogador
    // 1 maquina 2 jogador 0 empate

    public static Integer quemGanhou(char[] tabuleiro, String simboloJogador, String simboloMaquina){

        char simboloJogadorChar = simboloJogador.charAt(0);
        char simboloMaquinaChar = simboloMaquina.charAt(0);

        int[][] combinacoes = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] combo : combinacoes) {
            if (tabuleiro[combo[0]] == simboloMaquinaChar &&
                    tabuleiro[combo[1]] == simboloMaquinaChar &&
                    tabuleiro[combo[2]] == simboloMaquinaChar) {
                return 1;
            }
        }

        for (int[] combo : combinacoes) {
            if (tabuleiro[combo[0]] == simboloJogadorChar &&
                    tabuleiro[combo[1]] == simboloJogadorChar &&
                    tabuleiro[combo[2]] == simboloJogadorChar) {
                return 2;
            }
        }
        boolean cheio = true;
        for (char c : tabuleiro) {
            if (c == '-') {
                cheio = false;
                break;
            }
        }
        if (cheio) return 0;

        return null;
    }
}
