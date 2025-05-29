package jogo;

import java.util.Scanner;

import static jogo.ModoNormal.modoNormal;
import static jogo.modoImpossivel.Loop.jogarModoDificil;


public class Menu {
    public static void menu(char[] tabuleiro) {
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

            if (dificuldade == 1){
                jogarModoDificil(tabuleiro);
            }else {
                modoNormal();
            }
        }else {
            //funcao jogar com amigo
        }
    }
}
