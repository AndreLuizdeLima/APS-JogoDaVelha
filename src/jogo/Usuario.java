package jogo;

import java.util.Scanner;

public class Usuario {
    public static String setarJogador(){
            Scanner scan = new Scanner(System.in);
            System.out.println("=====================================================");
            System.out.println("🎮 Bem-vindo ao Jogo da Velha! 🕹️");
            System.out.println("Antes de começarmos a sua épica batalha dos X e O...");
            System.out.print("👉 Informe seu nome para começar a jogar: ");
            String nome = scan.nextLine();

            System.out.print("Escolha seu símbolo (X ou O): ");
            String simbolo = scan.nextLine().toUpperCase();

            while (!simbolo.equals("X") && !simbolo.equals("O")) {
                System.out.print("Entrada inválida. Digite X ou O: ");
                simbolo = scan.nextLine().toUpperCase();
            }

            System.out.println("Boa sorte, " + nome + "! Você escolheu jogar com '" + simbolo + "'! ✨");
        return nome;
    }
}
