import javax.swing.JOptionPane;

public class exc480 {
    public static void main(String[] args) {
        int n = getIntInput("Digite um número:");
        int x = reverso(n);
        JOptionPane.showMessageDialog(null, n + " - " + x);
        JOptionPane.showMessageDialog(null, x == n ? "É um número capicua" : "Não é um número capicua");
    }

    private static int reverso(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
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
