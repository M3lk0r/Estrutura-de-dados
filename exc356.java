import java.util.Scanner;

public class exc356 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[15];
        double[] pr1 = new double[15];
        double[] pr2 = new double[15];
        int[] media = new int[15];
        String[] situacao = new String[15];

        // Entrada de dados para os 15 alunos
        for (int L = 0; L < 15; L++) {
            // Entrada do nome com limite de 30 caracteres
            System.out.print("\nDigite " + (L + 1) + " nome: ");
            nomes[L] = scanner.nextLine();
            
            while (nomes[L].length() > 30) {
                System.out.println("\nNomes com até 30 caracteres.");
                System.out.print("\nDigite " + (L + 1) + " nome: ");
                nomes[L] = scanner.nextLine();
            }

            // Garantir que o nome tenha 30 caracteres para tabulação
            while (nomes[L].length() < 30) {
                nomes[L] += " ";
            }

            // Entrada das notas
            System.out.print("Digite 1ª nota: ");
            pr1[L] = scanner.nextDouble();
            System.out.print("Digite 2ª nota: ");
            pr2[L] = scanner.nextDouble();
            scanner.nextLine();  // Consumir a nova linha após as notas

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
        System.out.println("\n\n\n\t\t\t\tRELACAO FINAL");
        for (int L = 0; L < 15; L++) {
            System.out.printf("\n%d - %s\t%.2f\t%.2f\t%d\t%s\n", (L + 1), nomes[L], pr1[L], pr2[L], media[L], situacao[L]);
        }

        scanner.close();
    }
}