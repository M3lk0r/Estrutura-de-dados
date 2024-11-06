import java.util.Scanner;

public class exc354 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Vetor para armazenar os 15 números
        int[] num = new int[15];

        // Entrada de 15 números
        for (int L = 0; L < 15; L++) {
            System.out.print("Digite o " + (L + 1) + "º número: ");
            num[L] = scanner.nextInt();
        }

        // Saída dos números com a mensagem "par" ou "ímpar"
        System.out.println("\nRELACAO DOS NUMEROS");
        for (int L = 0; L < 15; L++) {
            System.out.print((L + 1) + " - " + num[L]);
            if (num[L] % 2 == 0) {
                System.out.println(" é PAR");
            } else {
                System.out.println(" é ÍMPAR");
            }
        }

        scanner.close();
    }
}