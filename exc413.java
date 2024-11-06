import java.util.Scanner;

public class exc413 {
    public static void main(String[] args) {
        int[][] n = new int[5][5];
        int soma = 0;
        Scanner scanner = new Scanner(System.in);

        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                System.out.print("Digite o elemento n[" + (L + 1) + "][" + (c + 1) + "]: ");
                n[L][c] = scanner.nextInt();
            }
        }

        System.out.println("\nToda a matriz:");
        for (int[] row : n) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        for (int L = 1; L < 5; L++) {
            for (int c = 5 - L; c < 5; c++) {
                if (n[L][c] % 2 != 0) {
                    soma += n[L][c] * n[L][c];
                }
            }
        }

        double raizQuadrada = Math.sqrt(soma);
        System.out.println("\nRaiz quadrada da soma dos quadrados dos números ímpares: " + raizQuadrada);

        scanner.close();
    }
}
