import javax.swing.JOptionPane;

public class exc394 {

    public static void main(String[] args) {
        // Declaração das variáveis
        String[] nomes = new String[50];
        double[] nota1 = new double[50];
        double[] nota2 = new double[50];
        double[] media = new double[50];
        int flag = 0, flag1 = 0, flag2 = 0;

        while (true) {
            // Menu de opções
            String op = JOptionPane.showInputDialog("\n\n\nMENU\n1 - ENTRAR NOMES\n2 - ENTRAR 1ª NOTA\n3 - ENTRAR 2ª NOTA\n4 - CALCULAR MÉDIA\n5 - LISTAR NO DISPLAY\n6 - SAIR\nOPÇÃO: ");

            if (op.equals("1")) {
                flag = 1;
                for (int i = 0; i < 50; i++) {
                    while (true) {
                        String nome = JOptionPane.showInputDialog("Digite o nome do aluno " + (i + 1) + " (máximo 30 caracteres e todas as letras maiúsculas): ");
                        if (nome.length() <= 30) {
                            nomes[i] = nome.toUpperCase();
                            while (nomes[i].length() < 30) {
                                nomes[i] = nomes[i] + " ";
                            }
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Nome com até 30 caracteres.");
                        }
                    }
                }
            } else if (op.equals("2")) {
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "Não tem nome cadastrado.");
                } else {
                    flag1 = 1;
                    for (int i = 0; i < 50; i++) {
                        while (true) {
                            try {
                                nota1[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1ª nota do aluno " + (i + 1) + ": "));
                                if (nota1[i] < 0 || nota1[i] > 10) {
                                    JOptionPane.showMessageDialog(null, "Nota inválida. Digite uma nota entre 0 e 10.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Nota inválida. Digite um número.");
                            }
                        }
                    }
                }
            } else if (op.equals("3")) {
                if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "Não tem nome cadastrado.");
                } else {
                    flag2 = 1;
                    for (int i = 0; i < 50; i++) {
                        while (true) {
                            try {
                                nota2[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2ª nota do aluno " + (i + 1) + ": "));
                                if (nota2[i] < 0 || nota2[i] > 10) {
                                    JOptionPane.showMessageDialog(null, "Nota inválida. Digite uma nota entre 0 e 10.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Nota inválida. Digite um número.");
                            }
                        }
                    }
                }
            } else if (op.equals("4")) {
                if (flag == 0 || flag1 == 0 || flag2 == 0) {
                    JOptionPane.showMessageDialog(null, "Nem todos os dados estão cadastrados.");
                } else {
                    for (int i = 0; i < 50; i++) {
                        media[i] = (3 * nota1[i] + 7 * nota2[i]) / 10;
                    }
                }
            } else if (op.equals("5")) {
                if (flag == 0 || flag1 == 0 || flag2 == 0) {
                    JOptionPane.showMessageDialog(null, "Nem todos os dados estão cadastrados.");
                } else {
                    String resultado = "NOME\t\t\t\tNOTA1\tNOTA2\tMÉDIA\n";
                    for (int i = 0; i < 50; i++) {
                        resultado += nomes[i] + "\t" + nota1[i] + "\t" + nota2[i] + "\t" + media[i] + "\n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                }
            } else if (op.equals("6")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opção não disponível.");
            }
        }

        System.out.println("\nPrograma encerrado.");
    }
}