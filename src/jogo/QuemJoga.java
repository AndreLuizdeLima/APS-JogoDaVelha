package jogo;

import ferramentas.Aleatoridade;

import static ferramentas.Aleatoridade.numeroAleatorio;

public class QuemJoga {

    //Se for 1 e jogador
    //Se for 0 e a maquina
    private static Integer jogadorAtual = null;

    public static int quemJoga(){
        if (jogadorAtual == null) {
            jogadorAtual = defineQuemJoga(); // define 0 ou 1
        } else {
            jogadorAtual = 1 - jogadorAtual; // alterna entre 0 e 1
        }
        return jogadorAtual;
    }

    public static int defineQuemJoga(){
        int inicial = numeroAleatorio(0,2).intValue();
        return inicial;
    }

}
