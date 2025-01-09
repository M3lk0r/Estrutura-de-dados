import javax.swing.JOptionPane;

public class exc470 {
    public static void main(String[] args) {
        int num = getIntInput("Digite um número > 0:");
        boolean isPrimo = primo(num);
        JOptionPane.showMessageDialog(null, isPrimo ? num + " é primo" : num + " não é primo");
    }

    private static boolean primo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
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
