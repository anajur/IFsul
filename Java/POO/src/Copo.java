
public class Copo { 
	
	public String cor;
private int tamanho = 3;
 public boolean aberto;
	
	
public	void status() {
		System.out.println("cor " + this.cor);
		
		System.out.println("tamanho " + this.tamanho);
		
		System.out.println("esta aberto " + this.aberto);
	}
	
		private void abrir(){
			
			this.aberto = true;
		}
		
		public void fechar () {
		this.aberto = false;	}
		
		
	public	void beber() {
			
			if (this.aberto==true) {System.out.println("pode beber");}
			else { System.out.println("destampe primeiro");}
			
			
			
			
		}

}
