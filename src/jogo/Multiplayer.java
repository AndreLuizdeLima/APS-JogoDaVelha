package jogo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static ferramentas.ImprimeTabuleiro.imprimeTabuleiroLetras;
import static ferramentas.Ranking.*;
import static jogo.Menu.jogarNovamente;
import static jogo.Menu.menu;

public class Multiplayer {

    public static void modoComAmigo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Jogador 1: ");
        String nome1 = scanner.nextLine();
        System.out.print("Nome do Jogador 2: ");
        String nome2 = scanner.nextLine();

        setNomes(nome1, nome2);

        char simbolo1, simbolo2;
        while (true) {
            System.out.print(nome1 + ", escolha seu símbolo (X ou O): ");
            simbolo1 = Character.toUpperCase(scanner.next().charAt(0));
            scanner.nextLine(); // limpar buffer
            if (simbolo1 == 'X' || simbolo1 == 'O') break;
            System.out.println("Símbolo inválido.");
        }
        simbolo2 = (simbolo1 == 'X') ? 'O' : 'X';

        System.out.println(nome1 + " é '" + simbolo1 + "', " + nome2 + " é '" + simbolo2 + "'");

        Map<String, Integer> coordenadas = new HashMap<>();
        coordenadas.put("A1", 0); coordenadas.put("A2", 1); coordenadas.put("A3", 2);
        coordenadas.put("B1", 3); coordenadas.put("B2", 4); coordenadas.put("B3", 5);
        coordenadas.put("C1", 6); coordenadas.put("C2", 7); coordenadas.put("C3", 8);

        boolean jogarNovamente;
        do {
            char[] tabuleiro = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
            String jogadorAtual = nome1;
            char simboloAtual = simbolo1;

            while (true) {
                imprimeTabuleiroLetras(tabuleiro);
                System.out.print(jogadorAtual + ", escolha uma posição (ex: A1, B3): ");
                String entrada = scanner.next().toUpperCase();

                if (!coordenadas.containsKey(entrada)) {
                    System.out.println("Posição inválida. Tente novamente.");
                    continue;
                }

                int posicao = coordenadas.get(entrada);
                if (tabuleiro[posicao] != '-') {
                    System.out.println("Essa posição já está ocupada. Tente outra.");
                    continue;
                }

                tabuleiro[posicao] = simboloAtual;

                Integer resultado = QuemVenceu.quemGanhou(tabuleiro, simbolo1, simbolo2);
                if (resultado != null) {
                    imprimeTabuleiroLetras(tabuleiro);
                    if (resultado == 2) {
                        System.out.println(jogadorAtual + " venceu!");
                        if (jogadorAtual.equals(nome1)) {
                            registrarVitoria(2);
                        } else {
                            registrarVitoria(3);
                        }
                    } else if (resultado == 0) {
                        System.out.println("Empate!");
                        registrarVitoria(0);
                    }
                    exibirRanking();
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

        } while (jogarNovamente() == 1);
    }
}