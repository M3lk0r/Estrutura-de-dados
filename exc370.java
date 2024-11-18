import javax.swing.JOptionPane;

public class exc370 {

    public static void main(String[] args) {
        // Número de voos
        int nv = Integer.parseInt(JOptionPane.showInputDialog("Entre com o número de voos: "));

        // Arrays para armazenar os dados dos voos
        String[] nome = new String[nv];   // Nome do voo
        int[] voos = new int[nv];          // Quantidade de lugares disponíveis

        // Leitura dos dados dos voos
        for (int i = 0; i < nv; i++) {
            nome[i] = JOptionPane.showInputDialog("Entre com a identificação do voo " + (i + 1) + ": ");
            voos[i] = Integer.parseInt(JOptionPane.showInputDialog("Entre com a quantidade de lugares disponíveis no voo " + nome[i] + ": "));
        }

        // Início do processo de reservas
        String nvd;
        do {
            nvd = JOptionPane.showInputDialog("\nEntre com o número do voo desejado ou 'O' para terminar: ");

            if (!nvd.equals("O")) {
                // Verifica se o voo existe
                int i = 0;
                while (i < nv && !nome[i].equals(nvd)) {
                    i++;
                }

                if (i < nv) {  // Voo encontrado
                    if (voos[i] > 0) {  // Se há lugares disponíveis
                        voos[i]--;  // Atualiza o número de lugares disponíveis
                        String id = JOptionPane.showInputDialog("\nQual o número da identidade do cliente? ");
                        JOptionPane.showMessageDialog(null, "Identidade: " + id + " Voo: " + nvd);
                    } else {
                        JOptionPane.showMessageDialog(null, "\nNão existem mais lugares neste voo.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "\nNão existe este voo.");
                }
            }
        } while (!nvd.equals("O"));

        JOptionPane.showMessageDialog(null, "\nPrograma encerrado.");
    }
}