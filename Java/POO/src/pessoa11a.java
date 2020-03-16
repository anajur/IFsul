
public abstract class pessoa11a {


	protected String nome;
	protected int idade;
	protected String sexo;
	
	
	
	@Override
	public String toString() {
		return "pessoa11a [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + "]";
	}


	public void fazerAniver() {
		this.idade++;
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	

	
	
	
	
}
