package jogo;

import java.util.Scanner;

public class JogadasUser {
    public static void ondeJoga(char[] tabuleiro, String simbolo) {
        boolean jogadaValida = false;
        do {
            Scanner scan = new Scanner(System.in);
            char sim = simbolo.charAt(0);

            System.out.println("Informe em qual linha deseja jogar (1 a 3)");
            int linha = scan.nextInt();

            System.out.println("Informe em qual coluna deseja jogar(1 a 3)");
            int coluna = scan.nextInt();

            int jogada = setaJogada(linha, coluna);
            jogadaValida = validaJogada(jogada, tabuleiro);

            if (jogadaValida == true) {
                tabuleiro[jogada] = sim;
            }else {
                System.out.println("\nPosição inválida \n");
            }
        }while (jogadaValida == false);
    }

    public static int setaJogada(int linha, int coluna) {
        int posicaoVetor = 0;
        int valor = -1;
        exemplo:
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                valor++;
                if (linha == i && coluna == j) {
                    break exemplo;
                }
            }
        }

        return valor;
    }

    public static boolean validaJogada(int posVetor, char[] tabuleiro) {
        if (tabuleiro[posVetor] == '-') {
            return true;
        }
        return false;
    }
}

