package ferramentas;

import java.util.Random;

public class Aleatoridade {

    public static Double numeroAleatorio(double min, double max){
        Double num = min + (max - min) * new Random().nextDouble();
        return num;
    }
}
//Comportamento da maquina modo facil, escolhendo aleatoriamente os campos

