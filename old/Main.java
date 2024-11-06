import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        int opcao;

        do {
            String[] opcoes = {"Cadastrar Matéria", "Listar Matérias", "Sair"};
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu de Cadastro",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcao) {
                case 0: // Cadastrar Matéria
                    String nome = JOptionPane.showInputDialog("Nome da Matéria:");
                    String disciplina = JOptionPane.showInputDialog("Disciplina:");
                    String periodo = JOptionPane.showInputDialog("Período:");
                    Materia novaMateria = new Materia(nome, disciplina, periodo);
                    cadastro.adicionarMateria(novaMateria);
                    JOptionPane.showMessageDialog(null, "Matéria cadastrada com sucesso!");
                    break;

                case 1: // Listar Matérias
                    String lista = cadastro.listarMaterias();
                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma matéria cadastrada.");
                    } else {
                        JOptionPane.showMessageDialog(null, lista);
                    }
                    break;

                case 2: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    break;
            }
        } while (opcao != 2);
    }
}