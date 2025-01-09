
import javax.swing.JOptionPane;

public class exc346 {

    public static void main(String[] args) {
        String frase;
        int op;

        do {
            // Exibe o menu
            String menu = "MENU\n"
                    + "1 - Imprime o comprimento da frase\n"
                    + "2 - Imprime os dois primeiros e os dois últimos caracteres da frase\n"
                    + "3 - Imprime a frase espelhada\n"
                    + "4 - Termina o algoritmo";

            // Lê a opção do usuário
            String input = JOptionPane.showInputDialog(null, menu, "Opções", JOptionPane.INFORMATION_MESSAGE);
            op = Integer.parseInt(input);

            switch (op) {
                case 1:
                    // Opção 1: Imprime o comprimento da frase
                    input = JOptionPane.showInputDialog(null, "Digite uma frase:", "Frase",
                            JOptionPane.INFORMATION_MESSAGE);
                    frase = input;
                    JOptionPane.showMessageDialog(null, "Número de caracteres da frase: " + frase.length());
                    break;
                case 2:
                    // Opção 2: Imprime os dois primeiros e os dois últimos caracteres
                    input = JOptionPane.showInputDialog(null, "Digite uma frase:", "Frase",
                            JOptionPane.INFORMATION_MESSAGE);
                    frase = input;
                    if (frase.length() >= 2) {
                        String doisPrimeiros = frase.substring(0, 2);
                        String doisUltimos = frase.substring(frase.length() - 2);
                        JOptionPane.showMessageDialog(null, "Os dois primeiros caracteres: " + doisPrimeiros + "\n"
                                + "Os dois últimos caracteres: " + doisUltimos);
                    } else {
                        JOptionPane.showMessageDialog(null, "A frase deve ter pelo menos 2 caracteres.", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    // Opção 3: Imprime a frase espelhada
                    input = JOptionPane.showInputDialog(null, "Digite uma frase:", "Frase",
                            JOptionPane.INFORMATION_MESSAGE);
                    frase = input;
                    StringBuilder fraseEspelhada = new StringBuilder(frase);
                    JOptionPane.showMessageDialog(null, "Frase espelhada: " + fraseEspelhada.reverse().toString());
                    break;
                case 4:
                    // Opção 4: Finaliza o algoritmo
                    JOptionPane.showMessageDialog(null, "Fim do algoritmo.");
                    break;
                default:
                    // Caso o usuário escolha uma opção inválida
                    JOptionPane.showMessageDialog(null, "Opção não disponível", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (op != 4); // Repete até a opção 4 ser escolhida
    }
}
