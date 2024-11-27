import javax.swing.JOptionPane;

public class exc490 {
    public static void main(String[] args) {
        String[] palavras = new String[10];
        int totalRetirados;

        for (int i = 0; i < 10; i++) {
            palavras[i] = JOptionPane.showInputDialog("Digite a palavra em letras minúsculas " + (i + 1) + ":");
        }

        StringBuilder relacao = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            totalRetirados = substituirCaracter(palavras[i], 'a'); // Substituindo 'a' por '*'
            relacao.append(i + 1).append(" - ").append(palavras[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, relacao.toString());
    }

    private static int substituirCaracter(String palavra, char caractere) {
        char[] caracteres = palavra.toCharArray();
        int count = 0;

        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == caractere) {
                caracteres[i] = '*';
                count++;
            }
        }

        // Convertendo o vetor de volta para uma String
        return count;
    }
}
