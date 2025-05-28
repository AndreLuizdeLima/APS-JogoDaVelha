package ferramentas;

public class Ranking {

    static int vitoriasPlayer1 = 0;
    static int vitoriasPlayer2 = 0;
    static int vitoriasMaquina = 0;
    static int empates = 0;

    public static void registrarVitoria(int vencedor) {
        if (vencedor == 2) {
            vitoriasPlayer1++;
        }if (vencedor == 3) {
            vitoriasPlayer2++;
        }if (vencedor == 1) {
            vitoriasMaquina++;
        }if (vencedor == 0) {
              empates++;
        }
    }

    public static void exibirRanking() {
        System.out.println("🏆 RANKING:");
        System.out.println("Player 1: " + vitoriasPlayer1);
        System.out.println("Player 2: " + vitoriasPlayer2);
        System.out.println("Máquina: " + vitoriasMaquina);
        System.out.println("Empates: " + empates);
    }
}