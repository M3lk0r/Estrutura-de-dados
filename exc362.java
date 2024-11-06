import java.util.Scanner;
import java.util.HashSet;

public class exc362 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vetores para armazenar os dois conjuntos
        int[] vet1 = new int[10];
        int[] vet2 = new int[20];
        
        // HashSet para armazenar elementos comuns sem repetições
        HashSet<Integer> comuns = new HashSet<>();
        
        // Entrada dos dados para o vetor 1 (10 elementos)
        System.out.println("Entrada de dados do vetor 1 (10 elementos)");
        for (int i = 0; i < 10; i++) {
            System.out.print("Entre com o " + (i + 1) + "º elemento: ");
            vet1[i] = scanner.nextInt();
        }

        // Entrada dos dados para o vetor 2 (20 elementos)
        System.out.println("Entrada de dados do vetor 2 (20 elementos)");
        for (int i = 0; i < 20; i++) {
            System.out.print("Entre com o " + (i + 1) + "º elemento: ");
            vet2[i] = scanner.nextInt();
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
            System.out.println("\nElementos comuns:");
            for (Integer elem : comuns) {
                System.out.println(elem);
            }
        } else {
            System.out.println("\nNão existem elementos comuns.");
        }

        scanner.close();
    }
}