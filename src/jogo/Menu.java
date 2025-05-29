package jogo;

import java.util.Scanner;

import static ferramentas.Ranking.exibirRanking;
import static jogo.ModoNormal.modoNormal;
import static jogo.modoImpossivel.Loop.jogarModoDificil;

public class Menu {
    public static void menu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Selecione uma opção de jogo:");
        System.out.println("""
                1 - Jogar contra a máquina
                2 - Jogar contra um amigo
                """);
        int opcao = scan.nextInt();

        if (opcao == 1) {
            System.out.println("Qual modo de dificuldade você deseja?");
            System.out.println("""
                    1 - Impossível
                    2 - Normal
                    """);
            int dificuldade = scan.nextInt();

            if (dificuldade == 1) {
                jogarModoDificil();
            } else {
                modoNormal();
            }
        } else {
            //funcao jogar com amigo
        }
    }

    public static int jogarNovamente() {
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Selecione a opção:");
            System.out.println("""
                1- Jogar novamente
                2- Voltar para o menu
                3- Sair
                """);

            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.println("Boa sorte!");
            } else if (opcao == 2) {
                exibirRanking();
                menu();
            } else if (opcao == 3) {
                exibirRanking();
                System.exit(0);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao < 1 || opcao > 3);

        return opcao;
    }

}

