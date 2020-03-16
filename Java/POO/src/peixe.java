
public class peixe extends animal {
	
	private String corEscama;
	
	@Override
	public void locomover() { System.out.println("nadando");}

	

		// TODO Auto-generated method stub
		
	

	@Override
	public void alimentar() {
		// TODO Auto-generated method stub
		System.out.println("comendo substancias");
	}

	@Override
	public void emitirSom() { System.out.println("peixe nao faz som");
		
		// TODO Auto-generated method stub
		
	}

	
	public void soltarBolha() { System.out.println("soltou bolhas");
}



	public String getCorEscama() {
		return corEscama;
	}



	public void setCorEscama(String corEscama) {
		this.corEscama = corEscama;
	}}
