package ferramentas;

public class Ranking {

    static int vitoriasPlayer = 0;
    static int vitoriasMaquina = 0;
    static int empates = 0;

    public static void registrarVitoria(int vencedor) {
        if (vencedor == 2) {
            vitoriasPlayer++;
        } if (vencedor == 1) {
            vitoriasMaquina++;
        } if (vencedor == 0) {
              empates++;
        }
    }

    public static void exibirRanking() {
        System.out.println("🏆 RANKING:");
        System.out.println("Player: " + vitoriasPlayer);
        System.out.println("Máquina: " + vitoriasMaquina);
        System.out.println("Empates: " + empates);
    }
}