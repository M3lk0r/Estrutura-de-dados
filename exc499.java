import java.util.Arrays;
import javax.swing.JOptionPane;

public class exc499 {
    public static void main(String[] args) {
        int[] num = new int[5];
        boolean flag = false;
        int op;

        do {
            op = getIntInput("""
                    \nMENU VETOR - FUNÇÃO
                    1 - Dados do VETOR
                    2 - Ordena VETOR
                    3 - Imprime VETOR
                    4 - Sai do programa
                    OPCAO:""");

            switch (op) {
                case 1 -> {
                    entrada(num);
                    flag = true;
                }
                case 2 -> {
                    if (flag) ordena(num);
                    else JOptionPane.showMessageDialog(null, "Escolha primeiro a opção 1.");
                }
                case 3 -> {
                    if (flag) imprime(num);
                    else JOptionPane.showMessageDialog(null, "Escolha primeiro a opção 1.");
                }
                case 4 -> JOptionPane.showMessageDialog(null, "Saindo do algoritmo.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (op != 4);
    }

    private static void entrada(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getIntInput("Digite o número " + (i + 1) + ":");
        }
    }

    private static void ordena(int[] array) {
        Arrays.sort(array);
    }

    private static void imprime(int[] array) {
        StringBuilder relacao = new StringBuilder("\nVETOR\n");
        for (int i = 0; i < array.length; i++) {
            relacao.append(i + 1).append(" - ").append(array[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, relacao.toString());
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
