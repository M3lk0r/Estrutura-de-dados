import java.util.Scanner;

public class exc394 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaração das variáveis
        String[] nomes = new String[50];
        double[] nota1 = new double[50];
        double[] nota2 = new double[50];
        double[] media = new double[50];
        int flag = 0, flag1 = 0, flag2 = 0;

        while (true) {
            // Menu de opções
            System.out.println("\n\n\n");
            System.out.println("MENU");
            System.out.println("1 - ENTRAR NOMES");
            System.out.println("2 - ENTRAR 1ª NOTA");
            System.out.println("3 - ENTRAR 2ª NOTA");
            System.out.println("4 - CALCULAR MÉDIA");
            System.out.println("5 - LISTAR NO DISPLAY");
            System.out.println("6 - SAIR");
            System.out.print("OPÇÃO: ");
            String op = scanner.nextLine();

            if (op.equals("1")) {
                flag = 1;
                for (int i = 0; i < 50; i++) {
                    System.out.print("Digite o nome do aluno " + (i + 1) + " (máximo 30 caracteres e todas as letras maiúsculas): ");
                    nomes[i] = scanner.nextLine();
                    while (nomes[i].length() > 30) {
                        System.out.print("Nome com até 30 caracteres. Digite novamente o nome do aluno " + (i + 1) + ": ");
                        nomes[i] = scanner.nextLine();
                    }
                    // Preenche o nome com espaços, caso tenha menos de 30 caracteres
                    while (nomes[i].length() < 30) {
                        nomes[i] = nomes[i] + " ";
                    }
                }
            } else if (op.equals("2")) {
                if (flag == 0) {
                    System.out.println("\nNão tem nome cadastrado.");
                } else {
                    flag1 = 1;
                    for (int i = 0; i < 50; i++) {
                        System.out.print("Digite a 1ª nota do aluno " + (i + 1) + ": ");
                        nota1[i] = scanner.nextDouble();
                    }
                    scanner.nextLine();  // Limpa o buffer
                }
            } else if (op.equals("3")) {
                if (flag == 0) {
                    System.out.println("\nNão tem nome cadastrado.");
                } else {
                    flag2 = 1;
                    for (int i = 0; i < 50; i++) {
                        System.out.print("Digite a 2ª nota do aluno " + (i + 1) + ": ");
                        nota2[i] = scanner.nextDouble();
                    }
                    scanner.nextLine();  // Limpa o buffer
                }
            } else if (op.equals("4")) {
                if (flag == 0 || flag1 == 0 || flag2 == 0) {
                    System.out.println("\nNem todos os dados estão cadastrados.");
                } else {
                    for (int i = 0; i < 50; i++) {
                        media[i] = (3 * nota1[i] + 7 * nota2[i]) / 10;
                    }
                }
            } else if (op.equals("5")) {
                if (flag == 0 || flag1 == 0 || flag2 == 0) {
                    System.out.println("\nNem todos os dados estão cadastrados.");
                } else {
                    System.out.println("\nNOME\t\t\t\tNOTA1\tNOTA2\tMÉDIA");
                    for (int i = 0; i < 50; i++) {
                        System.out.println(nomes[i] + "\t" + nota1[i] + "\t" + nota2[i] + "\t" + media[i]);
                    }
                }
            } else if (op.equals("6")) {
                break;
            } else {
                System.out.println("\nOpção não disponível.");
            }
        }

        scanner.close();
        System.out.println("\nPrograma encerrado.");
    }
}