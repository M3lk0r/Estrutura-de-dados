import java.util.Arrays;
import javax.swing.JOptionPane;

public class exc497 {
    public static void main(String[] args) {
        int[] num = new int[10];

        for (int i = 0; i < 10; i++) {
            num[i] = getIntInput("Digite o número " + (i + 1) + ":");
        }

        int n = getIntInput("Digite o número de busca:");
        ordena(num);
        int index = busca(num, n);

        StringBuilder relacao = new StringBuilder("\nVETOR\n");
        for (int i = 0; i < 10; i++) {
            relacao.append(i + 1).append(" - ").append(num[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, relacao.toString());
        JOptionPane.showMessageDialog(null, index != -1 ? "Posição no vetor: " + (index + 1) : "Não encontrado");
    }

    private static void ordena(int[] array) {
        Arrays.sort(array);
    }

    private static int busca(int[] array, int target) {
        int index = Arrays.binarySearch(array, target);
        return index >= 0 ? index : -1;
    }

    private static int getIntInput(String message) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(message));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número inteiro.");
            }
        }
    }
}
