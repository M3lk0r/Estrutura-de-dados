import javax.swing.JOptionPane;

public class exc500 {
    public static void main(String[] args) {
        int[] numA = new int[5];
        int[] numB = new int[5];
        boolean flagA = false, flagB = false;
        int op;

        do {
            op = getIntInput("""
                    \nVETORES - MENU
                    1 - Dados do VETOR A
                    2 - Dados do VETOR B
                    3 - Imprime VETORES
                    4 - Soma VETORES
                    5 - Subtrai VETORES
                    6 - Sai do programa
                    OPCAO:""");

            switch (op) {
                case 1 -> {
                    entrada(numA, "A");
                    flagA = true;
                }
                case 2 -> {
                    entrada(numB, "B");
                    flagB = true;
                }
                case 3 -> {
                    if (flagA && flagB) {
                        imprime(numA, "A");
                        imprime(numB, "B");
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro as opções 1 e 2.");
                    }
                }
                case 4 -> {
                    if (flagA && flagB) soma(numA, numB);
                    else JOptionPane.showMessageDialog(null, "Escolha primeiro as opções 1 e 2.");
                }
                case 5 -> {
                    if (flagA && flagB) subtrai(numA, numB);
                    else JOptionPane.showMessageDialog(null, "Escolha primeiro as opções 1 e 2.");
                }
                case 6 -> JOptionPane.showMessageDialog(null, "Saindo do programa.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (op != 6);
    }

    private static void entrada(int[] vetor, String nome) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = getIntInput("Digite o " + (i + 1) + "º valor do vetor " + nome + ":");
        }
    }

    private static void imprime(int[] vetor, String nome) {
        StringBuilder relacao = new StringBuilder("\nVETOR " + nome + ":\n");
        for (int i = 0; i < vetor.length; i++) {
            relacao.append(i + 1).append(" - ").append(vetor[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, relacao.toString());
    }

    private static void soma(int[] vetorA, int[] vetorB) {
        StringBuilder resultado = new StringBuilder("\nSOMA DOS VETORES:\n");
        for (int i = 0; i < vetorA.length; i++) {
            resultado.append(i + 1).append(" - ").append(vetorA[i] + vetorB[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private static void subtrai(int[] vetorA, int[] vetorB) {
        StringBuilder resultado = new StringBuilder("\nSUBTRAÇÃO DOS VETORES:\n");
        for (int i = 0; i < vetorA.length; i++) {
            resultado.append(i + 1).append(" - ").append(vetorA[i] - vetorB[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
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
