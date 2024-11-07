import javax.swing.JOptionPane;

public class exc358 {

    public static void main(String[] args) {
        double[] precoCompra = new double[100];
        double[] precoVenda = new double[100];
        double lucro;
        int totLucroMenor10 = 0, totLucroEntre10e20 = 0, totLucroMaior20 = 0;

        // Entrada dos preços de compra e venda para 100 mercadorias
        for (int i = 0; i < 100; i++) {
            while (true) {
                try {
                    precoCompra[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Preço de compra da mercadoria " + (i + 1) + ": "));
                    precoVenda[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Preço de venda da mercadoria " + (i + 1) + ": "));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Preço inválido. Digite novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Cálculo do lucro e contagem das mercadorias nas diferentes faixas de lucro
        for (int i = 0; i < 100; i++) {
            lucro = precoVenda[i] - precoCompra[i];
            double lucroPercentual = (lucro / precoCompra[i]) * 100;

            if (lucroPercentual < 10.0) {
                totLucroMenor10++;
            } else if (lucroPercentual <= 20.0) {
                totLucroEntre10e20++;
            } else {
                totLucroMaior20++;
            }
        }

        // Impressão dos resultados
        JOptionPane.showMessageDialog(null, "Total de mercadorias com lucro < 10%: " + totLucroMenor10);
        JOptionPane.showMessageDialog(null, "Total de mercadorias com 10% <= lucro <= 20%: " + totLucroEntre10e20);
        JOptionPane.showMessageDialog(null, "Total de mercadorias com lucro > 20%: " + totLucroMaior20);
    }
}