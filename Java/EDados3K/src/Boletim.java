
public class Boletim {



	private String nome;
	private double nota1, nota2, media=0;
	
	public Boletim(String nome, Double nota1, Double nota2) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double media) {
		this.media = media;
	}
	public double getMedia() {
		
	
	media= (this.getNota1()+ this.getNota2())/2;
	
	if(media>=6) {
		System.out.println("Aprovado!");
		
	}else {
	System.out.println("Reprovado, faltou "+ (media=6-media) +" para ficar na média");
	
	}return media;
	
	
	}
		
		
	
	
	
	
	
	
	

}
