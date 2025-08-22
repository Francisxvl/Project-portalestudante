Estudante.java       
   public class Estudante {

	 private int id;
	    private String nome;
	    private int idade;
	    private double nota;

	    public Estudante(int id, String nome, int idade, double nota) {
	        this.id = id;
	        this.nome = nome;
	        this.idade = idade;
	        this.nota = nota;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public int getIdade() {
	        return idade;
	    }

	    public double getNota() {
	        return nota;
	    }

	    @Override
	    public String toString() {
	        return id + ";" + nome + ";" + idade + ";" + nota;
	    }

	    public static Estudante fromString(String linha) {
	        String[] dados = linha.split(";");
	        int id = Integer.parseInt(dados[0]);
	        String nome = dados[1];
	        int idade = Integer.parseInt(dados[2]);
	        double nota = Double.parseDouble(dados[3]);
	        return new Estudante(id, nome, idade, nota);
	    }
	}
