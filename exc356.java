import javax.swing.JOptionPane;

public class exc356 {

    public static void main(String[] args) {
        int quantidadeAlunos = 15;
        String[] nomes = new String[quantidadeAlunos];
        double[] pr1 = new double[quantidadeAlunos];
        double[] pr2 = new double[quantidadeAlunos];
        int[] media = new int[quantidadeAlunos];
        String[] situacao = new String[quantidadeAlunos];

        // Entrada de dados para os 15 alunos
        for (int L = 0; L < quantidadeAlunos; L++) {
            // Entrada do nome com limite de 30 caracteres
            nomes[L] = JOptionPane.showInputDialog(null, "Digite o " + (L + 1) + " nome:", "Entrada de dados", JOptionPane.PLAIN_MESSAGE);
            while (nomes[L].length() > 30) {
                JOptionPane.showMessageDialog(null, "Nomes com até 30 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                nomes[L] = JOptionPane.showInputDialog(null, "Digite o " + (L + 1) + " nome: ", "Entrada de dados", JOptionPane.PLAIN_MESSAGE);
            }

            // Garantir que o nome tenha 30 caracteres para tabulação
            while (nomes[L].length() < 30) {
                nomes[L] += " ";
            }

            // Entrada das notas com tratamento de erro
            while (true) {
                try {
                    String input1 = JOptionPane.showInputDialog(null, "Digite 1ª nota:", "Entrada de dados", JOptionPane.PLAIN_MESSAGE);
                    pr1[L] = Double.parseDouble(input1);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Nota inválida. Digite novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            while (true) {
                try {
                    String input2 = JOptionPane.showInputDialog(null, "Digite 2ª nota:", "Entrada de dados", JOptionPane.PLAIN_MESSAGE);
                    pr2[L] = Double.parseDouble(input2);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Nota inválida. Digite novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Calcular média arredondada
            media[L] = (int) Math.round((pr1[L] + pr2[L]) / 2);

            // Definir a situação (AP ou RP)
            if (media[L] >= 5) {
                situacao[L] = "AP";
            } else {
                situacao[L] = "RP";
            }
        }

        // Imprimir a relação final
        String output = "\n\n\n\t\t\t\tRELACAO FINAL\n";
        for (int L = 0; L < quantidadeAlunos; L++) {
            output += String.format("\n%d - %s\t%.2f\t%.2f\t%d\t%s\n", (L + 1), nomes[L], pr1[L], pr2[L], media[L], situacao[L]);
        }
        JOptionPane.showMessageDialog(null, output, "Relação final", JOptionPane.INFORMATION_MESSAGE);
    }
}