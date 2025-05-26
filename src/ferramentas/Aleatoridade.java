package ferramentas;

import java.util.Random;

public class Aleatoridade {

    public static Double numeroAleatorio(double min, double max){
        Double num = min + (max - min) * new Random().nextDouble();
        return num;
    }
}
//Comportamento da maquina modo facil, escolhendo aleatoriamente os campos

class Maquina {
    public static int[] maquina01(char[][] tabuleiro) {
        List<int[]> campoValido = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    campoValido.add(new int[]{i, j});
                }
            }
        }


        if (campoValido.isEmpty()) {
            return null;
        }


        Random rd = new Random();
        return campoValido.get(rd.nextInt(campoValido.size()));
    }
}

