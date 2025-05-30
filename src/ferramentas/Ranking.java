package ferramentas;

public class Ranking {
    static int vitoriasPlayer1 = 0;
    static String nomePlayer1;
    static int vitoriasPlayer2 = 0;
    static String nomePlayer2;
    static int vitoriasMaquina = 0;
    static int empates = 0;

    // Setar nomes dos jogadores
    public static void setNomes(String jogador1, String jogador2) {
        nomePlayer1 = jogador1;
        nomePlayer2 = jogador2;
    }

    public static void registrarVitoria(int vencedor) {
        if (vencedor == 2) {
            vitoriasPlayer1++;
        } else if (vencedor == 3) {
            vitoriasPlayer2++;
        } else if (vencedor == 1) {
            vitoriasMaquina++;
        } else if (vencedor == 0) {
            empates++;
        }
    }

    public static void exibirRanking() {
        System.out.println("\n🏆 RANKING:");
        System.out.println("Player 1 " + nomePlayer1 + ": " + vitoriasPlayer1 + " vitórias");
        System.out.println("Player 2 " + nomePlayer2 + ": " + vitoriasPlayer2 + " vitórias");
        System.out.println("Máquina: " + vitoriasMaquina + " vitórias");
        System.out.println("Empates: " + empates);
        System.out.println();
    }
}