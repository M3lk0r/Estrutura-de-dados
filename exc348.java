import java.util.Scanner;

public class exc348 {

    public static void main(String[] args) {
        // Declaração de variáveis
        String[] nomes = new String[5];
        double[] pr1 = new double[5];
        double[] pr2 = new double[5];
        double[] media = new double[5];
        
        Scanner scanner = new Scanner(System.in);
        
        // Entrada de dados
        for (int L = 0; L <= 4; L++) {
            System.out.println("\nDigite o nome do aluno " + (L + 1) + ": ");
            nomes[L] = scanner.nextLine();
            
            System.out.println("Digite a 1ª nota de " + nomes[L] + ": ");
            pr1[L] = scanner.nextDouble();
            
            System.out.println("Digite a 2ª nota de " + nomes[L] + ": ");
            pr2[L] = scanner.nextDouble();
            
            // Calculando a média
            media[L] = (pr1[L] + pr2[L]) / 2;
            scanner.nextLine(); // Limpar o buffer do scanner
        }
        
        // Saída de dados
        System.out.println("\n\n\n\t\t\t\tRELACÃO FINAL");
        for (int L = 0; L <= 4; L++) {
            System.out.println("\nAluno " + (L + 1) + " - " + nomes[L]);
            System.out.println("Nota 1: " + pr1[L] + "\tNota 2: " + pr2[L] + "\tMédia: " + media[L]);
        }
        
        scanner.close();
    }
}