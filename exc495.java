import java.util.Arrays;
import javax.swing.JOptionPane;

public class exc495 {
    public static void main(String[] args) {
        String[] nomes = new String[5];

        for (int i = 0; i < 5; i++) {
            nomes[i] = JOptionPane.showInputDialog("Digite o nome " + (i + 1) + ":");
        }

        ordena(nomes);

        StringBuilder relacao = new StringBuilder("\n\nNOMES ORDENADOS\n");
        for (int i = 0; i < 5; i++) {
            relacao.append(i + 1).append(" - ").append(nomes[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, relacao.toString());
    }

    private static void ordena(String[] array) {
        Arrays.sort(array);
    }
}
