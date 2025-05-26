package jogo;

import static jogo.QuemJoga.quemJoga;
import static jogo.Usuario.escolhaSimbulo;
import static jogo.Usuario.setarJogador;

public class Jogo {

    private char[] tabuleiro = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    public static void jogar() {

        while (true) {
            setarJogador();
            escolhaSimbulo();
            quemJoga();

            while (true) {
                if (quemJoga() == 1) {
                    //vez do jogador


                } else if (quemJoga() == 0) {
                    //vez da maquina

                }

            }


        }
    }

}
