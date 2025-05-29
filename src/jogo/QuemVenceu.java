package jogo;

public class QuemVenceu {

    // simbolo X ou O
    // simbolo é sempre o jogador
    // 1 maquina 2 jogador 0 empate

    public static Integer quemGanhou(char[] tabuleiro, Character simboloJogador, Character simboloMaquina){

        
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
            if (tabuleiro[combo[0]] == simboloMaquina &&
                    tabuleiro[combo[1]] == simboloMaquina &&
                    tabuleiro[combo[2]] == simboloMaquina) {
                return 1;
            }
        }

        for (int[] combo : combinacoes) {
            if (tabuleiro[combo[0]] == simboloJogador &&
                    tabuleiro[combo[1]] == simboloJogador &&
                    tabuleiro[combo[2]] == simboloJogador) {
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
