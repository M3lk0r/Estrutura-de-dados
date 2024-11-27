import javax.swing.JOptionPane;

public class exc460 {
    public static void main(String[] args) {
        for (int c = 1; c <= 3; c++) {
            int a = getIntInput("Digite um número:");
            JOptionPane.showMessageDialog(null, "Dobro: " + dob(a));
        }
    }

    private static int dob(int num) {
        return num * 2;
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
