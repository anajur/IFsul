
public class reptil extends animal {
	private String corEscama;

	@Override
	public void locomover() {
		System.out.println("Rastejando");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alimentar() {
		System.out.println("comendo vegetais");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emitirSom() {
		System.out.println("som de reptil");
		// TODO Auto-generated method stub
		
	}

	public String getCorEscama() {
		return corEscama;
	}

	public void setCorEscama(String corEscama) {
		this.corEscama = corEscama;
	}

}
