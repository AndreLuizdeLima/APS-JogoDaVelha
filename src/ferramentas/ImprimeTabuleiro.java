package ferramentas;

public class ImprimeTabuleiro {



     public static void imprimeTabuleiro(char[] tabuleiro){
        char[] posicoes = tabuleiro;

        System.out.print("""
             1   2   3
           +---+---+---+
        1  | %s | %s | %s |
           +---+---+---+
        2  | %s | %s | %s |
           +---+---+---+
        3  | %s | %s | %s |
           +---+---+---+
        """.formatted(
                posicoes[0], posicoes[1], posicoes[2],
                posicoes[3], posicoes[4], posicoes[5],
                posicoes[6], posicoes[7], posicoes[8]
        ));
    }

    public static void imprimeTabuleiroLetras(char[] tabuleiro){
        char[] posicoes = tabuleiro;

        System.out.print("""
             1   2   3
           +---+---+---+
        A  | %s | %s | %s |
           +---+---+---+
        B  | %s | %s | %s |
           +---+---+---+
        C  | %s | %s | %s |
           +---+---+---+
        """.formatted(
                posicoes[0], posicoes[1], posicoes[2],
                posicoes[3], posicoes[4], posicoes[5],
                posicoes[6], posicoes[7], posicoes[8]
        ));
    }


}

