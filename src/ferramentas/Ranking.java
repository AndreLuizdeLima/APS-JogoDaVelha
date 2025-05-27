 public class Ranking {

    static int vitoriasPlayer = 0;
    static int vitoriasMaquina = 0;
    static int empates = 0;

    public static void registrarVitoria(int vencedor) {
        if (vencedor == 1) {
            vitoriasPlayer++;
        } else if (vencedor == 0) {
            vitoriasMaquina++;
        } else {
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