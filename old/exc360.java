
import javax.swing.JOptionPane;

public class exc360 {

    public static void main(String[] args) {
        // Arrays para armazenar o último dia de cada mês e os signos correspondentes
        int[] ultimoDia = { 20, 19, 20, 20, 20, 20, 21, 22, 22, 22, 21, 21 };
        String[] signos = { "Capricórnio", "Aquário", "Peixes", "Áries", "Touro", "Gêmeos", "Câncer", "Leão",
                "Virgem", "Libra", "Escorpião", "Sagitário" };

        while (true) {
            // Leitura da data e verificação de cada data
            String inputData = JOptionPane.showInputDialog("Digite a data no formato ddmm ou 9999 para terminar:");
            if (inputData == null) {
                break;
            }

            try {
                int data = Integer.parseInt(inputData);
                if (data == 9999) {
                    break;
                }

                // Extrair o dia e o mês da data
                int dia = data / 100; // Extrai os dois primeiros números (dia)
                int mes = data % 100; // Extrai os dois últimos números (mês)

                if (mes < 1 || mes > 12) {
                    JOptionPane.showMessageDialog(null, "Mês inválido. Por favor, digite um mês entre 1 e 12.");
                    continue;
                }

                mes--; // Ajusta para o índice correto (meses começam de 0)

                // Verifica se o dia informado é maior que o último dia do mês
                if (dia > ultimoDia[mes]) {
                    mes = (mes + 1) % 12; // Muda para o signo do próximo mês
                }

                // Imprime o signo correspondente
                JOptionPane.showMessageDialog(null, "Signo: " + signos[mes]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
            }
        }
    }
}