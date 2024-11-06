import java.util.Scanner;

public class exc360 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays para armazenar o último dia de cada mês e os signos correspondentes
        int[] ultimoDia = {20, 19, 20, 20, 20, 20, 21, 22, 22, 22, 21, 21};
        String[] signos = {"Capricórnio", "Aquário", "Peixes", "Áries", "Touro", "Gêmeos", "Câncer", "Leão", 
                            "Virgem", "Libra", "Escorpião", "Sagitário"};

        // Leitura da data e verificação de cada data
        int data;
        System.out.print("\nDigite a data no formato ddmm ou 9999 para terminar: ");
        data = scanner.nextInt();

        while (data != 9999) {
            // Extrair o dia e o mês da data
            int dia = data / 100;  // Extrai os dois primeiros números (dia)
            int mes = data % 100;  // Extrai os dois últimos números (mês)

            mes--;  // Ajusta para o índice correto (meses começam de 0)

            // Verifica se o dia informado é maior que o último dia do mês
            if (dia > ultimoDia[mes]) {
                mes = (mes + 1) % 12;  // Muda para o signo do próximo mês
            }

            // Imprime o signo correspondente
            System.out.println("\nSigno: " + signos[mes] + "\n");

            // Solicita nova data
            System.out.print("\nDigite a data no formato ddmm ou 9999 para terminar: ");
            data = scanner.nextInt();
        }

        scanner.close();
    }
}