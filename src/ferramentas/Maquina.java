package ferramentas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maquina{
    public static int maquina01(char[] tabuleiro) {
        List<Integer> campoValido = new ArrayList<>();

        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i] == ' ') {
                campoValido.add(i);
            }
        }

        if (campoValido.isEmpty()) {
            return -1;
        }

        Random rd = new Random();
        return campoValido.get(rd.nextInt(campoValido.size()));
    }

}
