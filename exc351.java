import javax.swing.JOptionPane;

public class exc351 {

    public static void main(String[] args) {
        String[] nomes = new String[5];
        int num;

        // Entrada dos nomes
        for (int L = 0; L < 5; L++) {
            nomes[L] = JOptionPane.showInputDialog(null, "Nome " + (L + 1) + ": ", "Entrada de dados", JOptionPane.PLAIN_MESSAGE);
        }

        // Entrada do número para procurar o nome
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, "Digite o número da pessoa: ", "Entrada de dados", JOptionPane.PLAIN_MESSAGE);
                num = Integer.parseInt(input);
                if (num < 1 || num > 5) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido. Digite novamente: ", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Imprimir o nome correspondente ao número
        JOptionPane.showMessageDialog(null, nomes[num - 1], "Nome encontrado", JOptionPane.INFORMATION_MESSAGE);
    }
}

