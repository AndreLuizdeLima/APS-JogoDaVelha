package jogo;

import java.util.Scanner;

public class Multiplayer {
    public static void modoComAmigo() {
        Scanner scanner = new Scanner(System.in);
        char[] tabuleiro = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};

        // Nomes
        System.out.print("Nome do Jogador 1: ");
        String nome1 = scanner.nextLine();
        System.out.print("Nome do Jogador 2: ");
        String nome2 = scanner.nextLine();

        // Símbolos
        char simbolo1, simbolo2;
        while (true) {
            System.out.print(nome1 + ", escolha seu símbolo (X ou O): ");
            simbolo1 = Character.toUpperCase(scanner.next().charAt(0));
            if (simbolo1 == 'X' || simbolo1 == 'O') break;
            System.out.println("Símbolo inválido.");
        }
        simbolo2 = (simbolo1 == 'X') ? 'O' : 'X';

        System.out.println(nome1 + " é '" + simbolo1 + "', " + nome2 + " é '" + simbolo2 + "'");

        // Começa o jogo
        String jogadorAtual = nome1;
        char simboloAtual = simbolo1;

        while (true) {
            imprimirTabuleiro(tabuleiro);
            System.out.println(jogadorAtual + ", escolha uma posição (1-9): ");
            int posicao = scanner.nextInt() - 1;

            if (posicao < 0 || posicao > 8 || tabuleiro[posicao] != '-') {
                System.out.println("Jogada inválida. Tente novamente.");
                continue;
            }

            tabuleiro[posicao] = simboloAtual;

            int resultado = QuemVenceu.quemGanhou(tabuleiro, simbolo1, simbolo2);
            if (resultado == 2) {
                imprimirTabuleiro(tabuleiro);
                System.out.println(jogadorAtual + " venceu!");
                break;
            } else if (resultado == 0) {
                imprimirTabuleiro(tabuleiro);
                System.out.println("Empate!");
                break;
            }

            // Trocar jogador
            if (jogadorAtual.equals(nome1)) {
                jogadorAtual = nome2;
                simboloAtual = simbolo2;
            } else {
                jogadorAtual = nome1;
                simboloAtual = simbolo1;
            }
        }
    }

    private static void imprimirTabuleiro(char[] tabuleiro) {
        System.out.println();
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(" " + tabuleiro[i] + " ");
            if ((i + 1) % 3 == 0) System.out.println();
        }
        System.out.println();
    }
}


