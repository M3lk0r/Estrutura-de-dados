import java.util.Scanner;

public class exc370 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Número de voos
        int nv;
        System.out.print("Entre com o número de voos: ");
        nv = scanner.nextInt();
        scanner.nextLine(); // Consome o newline

        // Arrays para armazenar os dados dos voos
        String[] nome = new String[nv];   // Nome do voo
        int[] voos = new int[nv];          // Quantidade de lugares disponíveis

        // Leitura dos dados dos voos
        for (int i = 0; i < nv; i++) {
            System.out.print("Entre com a identificação do voo " + (i + 1) + ": ");
            nome[i] = scanner.nextLine();
            System.out.print("Entre com a quantidade de lugares disponíveis no voo " + nome[i] + ": ");
            voos[i] = scanner.nextInt();
            scanner.nextLine(); // Consome o newline
        }

        // Início do processo de reservas
        String nvd;
        do {
            System.out.print("\nEntre com o número do voo desejado ou 'O' para terminar: ");
            nvd = scanner.nextLine();

            if (!nvd.equals("O")) {
                // Verifica se o voo existe
                int i = 0;
                while (i < nv && !nome[i].equals(nvd)) {
                    i++;
                }

                if (i < nv) {  // Voo encontrado
                    if (voos[i] > 0) {  // Se há lugares disponíveis
                        voos[i]--;  // Atualiza o número de lugares disponíveis
                        System.out.print("\nQual o número da identidade do cliente? ");
                        String id = scanner.nextLine();
                        System.out.println("Identidade: " + id + " Voo: " + nvd + "\n");
                    } else {
                        System.out.println("\nNão existem mais lugares neste voo.\n");
                    }
                } else {
                    System.out.println("\nNão existe este voo.\n");
                }
            }
        } while (!nvd.equals("O"));

        System.out.println("\nPrograma encerrado.");
        scanner.close();
    }
}