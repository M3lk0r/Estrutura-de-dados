import java.util.Scanner;

public class exc346 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase;
        int op;
        
        do {
            // Exibe o menu
            System.out.println("\nMENU");
            System.out.println("1 - Imprime o comprimento da frase");
            System.out.println("2 - Imprime os dois primeiros e os dois últimos caracteres da frase");
            System.out.println("3 - Imprime a frase espelhada");
            System.out.println("4 - Termina o algoritmo");
            System.out.print("OPCAO: ");
            
            // Lê a opção do usuário
            op = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            switch (op) {
                case 1:
                    // Opção 1: Imprime o comprimento da frase
                    System.out.print("\nDigite uma frase: ");
                    frase = scanner.nextLine();
                    System.out.println("Número de caracteres da frase: " + frase.length());
                    break;
                case 2:
                    // Opção 2: Imprime os dois primeiros e os dois últimos caracteres
                    System.out.print("\nDigite uma frase: ");
                    frase = scanner.nextLine();
                    if (frase.length() >= 2) {
                        System.out.println("Os dois primeiros caracteres: " + frase.substring(0, 2));
                        System.out.println("Os dois últimos caracteres: " + frase.substring(frase.length() - 2));
                    } else {
                        System.out.println("A frase deve ter pelo menos 2 caracteres.");
                    }
                    break;
                case 3:
                    // Opção 3: Imprime a frase espelhada
                    System.out.print("\nDigite uma frase: ");
                    frase = scanner.nextLine();
                    StringBuilder fraseEspelhada = new StringBuilder(frase);
                    System.out.println("Frase espelhada: " + fraseEspelhada.reverse().toString());
                    break;
                case 4:
                    // Opção 4: Finaliza o algoritmo
                    System.out.println("\nFim do algoritmo.");
                    break;
                default:
                    // Caso o usuário escolha uma opção inválida
                    System.out.println("\nOpção não disponível");
            }
            System.out.println("\n");

        } while (op != 4);  // Repete até a opção 4 ser escolhida

        scanner.close();
    }
}