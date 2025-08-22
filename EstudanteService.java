EstudanteService.java : import java.io.*;
import java.util.*;

public class EstudanteService {
	 private List<Estudante> estudantes;
	    private EstudanteRepositorio repositorio;

	    public EstudanteService() {
	        repositorio = new EstudanteRepositorio();
	        estudantes = repositorio.carregarEstudantes();
	    }

	    public void adicionarEstudante(String nome, int idade, double nota) throws IOException {
	        int id = estudantes.isEmpty() ? 1 : estudantes.get(estudantes.size() - 1).getId() + 1;
	        Estudante e = new Estudante(id, nome, idade, nota);
	        estudantes.add(e);
	        repositorio.salvarTodos(estudantes);
	        System.out.println("✅ Estudante cadastrado com ID: " + id);
	    }

	    public void listarEstudantes() {
	        if (estudantes.isEmpty()) {
	            System.out.println("Nenhum estudante cadastrado.");
	        } else {
	            for (Estudante e : estudantes) {
	                System.out.println(e.getId() + " - " + e.getNome() + " (" + e.getIdade() + " anos) - Nota: " + e.getNota());
	            }
	        }
	    }

	    public void atualizarEstudante(int id, String nome, int idade, double nota) throws IOException {
	        for (int i = 0; i < estudantes.size(); i++) {
	            if (estudantes.get(i).getId() == id) {
	                estudantes.set(i, new Estudante(id, nome, idade, nota));
	                repositorio.salvarTodos(estudantes);
	                System.out.println("✅ Estudante atualizado.");
	                return;
	            }
	        }
	        System.out.println("❌ Estudante com ID " + id + " não encontrado.");
	    }

	    public void removerEstudante(int id) throws IOException {
	        Iterator<Estudante> it = estudantes.iterator();
	        boolean encontrado = false;

	        while (it.hasNext()) {
	            Estudante e = it.next();
	            if (e.getId() == id) {
	                it.remove();
	                encontrado = true;
	                break;
	            }
	        }

	        if (encontrado) {
	            repositorio.salvarTodos(estudantes);
	            System.out.println("✅ Estudante removido.");
	        } else {
	            System.out.println("❌ Estudante com ID " + id + " não encontrado.");
	        }
	    }

	    public void calcularMediaNotas() {
	        if (estudantes.isEmpty()) {
	            System.out.println("Nenhum estudante cadastrado.");
	        } else {
	            double media = estudantes.stream().mapToDouble(Estudante::getNota).average().orElse(0.0);
	            System.out.println("📊 Média das notas: " + media);
	        }
	    }
	}
