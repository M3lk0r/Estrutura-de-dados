public class Materia {
    private String nome;
    private String disciplina;
    private String periodo;

    public Materia(String nome, String disciplina, String periodo) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.periodo = periodo;
    }

    public String getNome() {
        return nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    @Override
    public String toString() {
        return "Matéria: " + nome + ", Disciplina: " + disciplina + ", Período: " + periodo;
    }
}