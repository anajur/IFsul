
public class mamifero extends animal {

	private String corPelo;
	
	@Override
	public void locomover() {
		System.out.println("correndo");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alimentar() {
		System.out.println("mamando");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emitirSom() {
		System.out.println("som de mamifero");
		// TODO Auto-generated method stub
		
	}

	public String getCorPelo() {
		return corPelo;
	}

	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}
	
	
	

}
