import javax.swing.JOptionPane;

public class exc348 {

    public static void main(String[] args) {
        // Declaração de variáveis
        String[] nomes = new String[5];
        double[] pr1 = new double[5];
        double[] pr2 = new double[5];
        double[] media = new double[5];
        
        // Entrada de dados
        for (int L = 0; L <= 4; L++) {
            nomes[L] = JOptionPane.showInputDialog("\nDigite o nome do aluno " + (L + 1) + ": ");
            
            // Tratamento de input inválido
            while (true) {
                try {
                    pr1[L] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1ª nota de " + nomes[L] + ": "));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Nota inválida. Digite novamente: ", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            // Tratamento de input inválido
            while (true) {
                try {
                    pr2[L] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2ª nota de " + nomes[L] + ": "));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Nota inválida. Digite novamente: ", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            // Calculando a média
            media[L] = (pr1[L] + pr2[L]) / 2;
        }
        
        // Saída de dados
        String saida = "\n\n\n\t\t\t\tRELACÃO FINAL";
        for (int L = 0; L <= 4; L++) {
            saida += "\nAluno " + (L + 1) + " - " + nomes[L] + "\nNota 1: " + pr1[L] + "\tNota 2: " + pr2[L] + "\tMédia: " + media[L];
        }
        JOptionPane.showMessageDialog(null, saida);
    }
}

