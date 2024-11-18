import javax.swing.JOptionPane;

public class exc362 {

    public static void main(String[] args) {
        // Vetores para armazenar os dois conjuntos
        int[] vet1 = new int[10];
        int[] vet2 = new int[20];

        // HashSet para armazenar elementos comuns sem repetições
        java.util.HashSet<Integer> comuns = new java.util.HashSet<>();

        // Entrada dos dados para o vetor 1 (10 elementos)
        for (int i = 0; i < 10; i++) {
            while (true) {
                try {
                    vet1[i] = Integer.parseInt(JOptionPane.showInputDialog("Entre com o " + (i + 1) + "º elemento do vetor 1:"));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
                }
            }
        }

        // Entrada dos dados para o vetor 2 (20 elementos)
        for (int i = 0; i < 20; i++) {
            while (true) {
                try {
                    vet2[i] = Integer.parseInt(JOptionPane.showInputDialog("Entre com o " + (i + 1) + "º elemento do vetor 2:"));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número.");
                }
            }
        }

        // Encontrando elementos comuns entre vet1 e vet2
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (vet1[i] == vet2[j]) {
                    comuns.add(vet1[i]); // Adiciona ao HashSet para evitar duplicados
                    break; // Elemento já encontrado, não é necessário verificar mais
                }
            }
        }

        // Exibindo os resultados
        if (!comuns.isEmpty()) {
            StringBuilder resultado = new StringBuilder("Elementos comuns:\n");
            for (Integer elem : comuns) {
                resultado.append(elem).append("\n");
            }
            JOptionPane.showMessageDialog(null, resultado.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Não existem elementos comuns.");
        }
    }
}