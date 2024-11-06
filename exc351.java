import java.util.Scanner;

public class exc351 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[5];
        int num;

        // Entrada dos nomes
        for (int L = 0; L < 5; L++) {
            System.out.print("\nNome " + (L + 1) + ": ");
            nomes[L] = scanner.nextLine();
        }

        // Entrada do número para procurar o nome
        System.out.print("\nDigite o número da pessoa: ");
        num = scanner.nextInt();

        // Validação do número
        while (num < 1 || num > 5) {
            System.out.println("Número fora do intervalo");
            System.out.print("\nDigite o número da pessoa: ");
            num = scanner.nextInt();
        }

        // Imprimir o nome correspondente ao número
        System.out.println("\n" + nomes[num - 1]);
        
        scanner.close();
    }
}