
public class aluno11a extends pessoa11a {

	
	private int matricula;
	private String curso;
	
	
public void	pagarMens(){
	System.out.println("pagando mensalidade de " + this.nome);
}


public int getMatricula() {
	return matricula;
}


public void setMatricula(int matricula) {
	this.matricula = matricula;
}


public String getCurso() {
	return curso;
}


public void setCurso(String curso) {
	this.curso = curso;
}


	
}
