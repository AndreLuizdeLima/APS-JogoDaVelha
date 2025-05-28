package jogo;

import static ferramentas.ImprimeTabuleiro.imprimeTabuleiro;
import static ferramentas.Maquina.maquinaJogada;
import static jogo.JogadasUser.ondeJoga;
import static jogo.QuemJoga.quemJoga;
import static jogo.Usuario.escolhaSimbulo;
import static jogo.Usuario.setarJogador;

public class Jogo {

    public static void jogar() {
        char[] tabuleiro = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};

        while (true) {
            setarJogador();
            String simbolo = escolhaSimbulo();
            quemJoga();
            ondeJoga(tabuleiro,simbolo);
            imprimeTabuleiro(tabuleiro);

//            while (true) {
//                 (quemJoga() == 1) {
//                    vez do jogador
//
//
//                } else if (quemJoga() == 0) {
//                    vez da maquina
//                    int jogada = maquinaJogada(tabuleiro);
//                }
//
//            }


       }
    }

}
