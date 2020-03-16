
public class UFC {

private String nome;
private String nacionalidade;
private int idade;
private float altura;
private float peso;
private String categoria;
private int vitorias;
private int derrotas;
private int empates;


public UFC(String no, String na, int i, float a, float p, int v,
		int d, int e) {
	
	this.nome = no;
	this.nacionalidade = na;
	
	this.idade = i;
	this.altura = a;
	
	this.setPeso(p);
	
	
	
	this.vitorias = v;
	this.derrotas = d;
	this.empates = e;
}

public String getNome() {
	return nome;
}

public void setNome(String no) {
	this.nome = no;
}

public String getNacionalidade() {
	return nacionalidade;
}

public void setNacionalidade(String na) {
	this.nacionalidade = na;
}

public int getIdade() {
	return idade;
}

public void setI(int i) {
	this.idade = i;
}

public float getAltura() {
	return altura;
}

public void setAltura(float a) {
	this.altura = a;
}

public float getPeso() {
	return peso;
}

public void setPeso(float p) {
	this.peso = p;
	this.setCategoria();

}

public String getCategoria() {
	return categoria;
}

public void setCategoria() {
	this.categoria = categoria;
	
	
	if (this.peso <52.2) { this.categoria="Invalido";}
	else if (this.peso<=70.3) { this.categoria= "PL";}
	else if (this.peso<=83.9) { this.categoria= "PM";}
	else if (this.peso<=120.2) {this.categoria = "PP";}
	else {this.categoria ="inválido";}
}

public int getVitorias() {
	return vitorias;
}

public void setVitorias(int vitorias) {
	this.vitorias = vitorias;
}

public int getDerrotas() {
	return derrotas;
}

public void setDerrotas(int derrotas) {
	this.derrotas = derrotas;
}

public int getEmpates() {
	return empates;
}

public void setEmpates(int empates) {
	this.empates = empates;
}

public void apresenta() {
	
	System.out.println("Lutador: " + getNome());
	System.out.println("Origem " + getNacionalidade());
	System.out.println(getIdade() + "anos");
	System.out.println(getAltura() + "m de altura");
	System.out.println("Pesando " + getPeso() + "Kg");
	System.out.println("Ganhou " + getVitorias());
	System.out.println("Perdeu " + getDerrotas());
	System.out.println("Empatou " + getEmpates());
}

public void status() {
	System.out.println(getNome()+ " é "+getCategoria());
	System.out.println(getVitorias() +  " vitórias");
	System.out.println(getDerrotas() + " derrotas");
	System.out.println(getEmpates() + " empates" );
	
}

	public void ganharLuta() {
	this.setVitorias(this.getVitorias()+1);
}

	public void perderLuta()
{ this.setDerrotas(this.getDerrotas()+1);}

	public void empatarLuta(){
	this.setEmpates(this.getEmpates()+1);}
}

