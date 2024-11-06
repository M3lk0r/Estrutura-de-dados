import java.util.ArrayList;
import java.util.List;

public class Cadastro{
    private List<Materia> materias;

    public Cadastro() {
        this.materias = new ArrayList<>();
    }

    public void adicionarMateria(Materia materia) {
        materias.add(materia);
    }

    public String listarMaterias() {
        StringBuilder lista = new StringBuilder();
        for (Materia materia : materias) {
            lista.append(materia.toString()).append("\n");
        }
        return lista.toString();
    }
}