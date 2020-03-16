
public class Caneta9 {

public String modelo;
private float ponta;
 private boolean tampada;
private String cor;

public  Caneta9(String m, float p, String c) {
	this.modelo = m;
	this.ponta = p;
	this.cor = c;
	
	this.tampar();

}

	public String getModelo() {

		return this.modelo; 
	}
	public void setModelo(String m) {
		this.modelo = m;
	}
	
	public float getPonta() {
	return this.ponta;
}
	public void setPonta (float p) {
		this.ponta = p;
	}
	
	public void tampar() {
		this.tampada = true;
	}
	
	
	public void destampar () {
		this.tampada = false;
	}
	public void status () {
		
		System.out.println("Modelo " + this.getModelo());
		System.out.println("Ponta  " + this.ponta);
		System.out.println("cor " + this.cor);
		System.out.println("tampada" +this.tampada);
	}


}
