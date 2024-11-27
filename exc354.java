
import javax.swing.JOptionPane;

public class exc354 {

    public static void main(String[] args) {
        // Vetor para armazenar os 15 números
        int[] num = new int[3];

        // Entrada de 15 números
        for (int L = 0; L < 3; L++) {
            while (true) {
                try {
                    num[L] = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o " + (L + 1) + "º número: ",
                            "Entrada de dados", JOptionPane.PLAIN_MESSAGE));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Digite novamente: ", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Saída dos números com a mensagem "par" ou "ímpar"
        String msg = "RELACAO DOS NUMEROS\n";
        for (int L = 0; L < 3; L++) {
            msg += (L + 1) + " - " + num[L];
            if (num[L] % 2 == 0) {
                msg += " é PAR\n";
            } else {
                msg += " é ÍMPAR\n";
            }
        }

        JOptionPane.showMessageDialog(null, msg, "Relação dos números", JOptionPane.INFORMATION_MESSAGE);
    }
}
