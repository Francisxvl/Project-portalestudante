EstudanteRepositorio.java 
import java.io.*;
import java.util.*;

public class EstudanteRepositorio {
    private static final String ARQUIVO = "estudantes.txt";

    public List<Estudante> carregarEstudantes() {
        List<Estudante> estudantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                estudantes.add(Estudante.fromString(linha));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
        return estudantes;
    }

    public void salvarTodos(List<Estudante> estudantes) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Estudante e : estudantes) {
                bw.write(e.toString());
                bw.newLine();
            }
        }
    }
}
