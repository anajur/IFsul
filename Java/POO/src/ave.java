
public class ave extends animal {
	
	private String corPena;

	@Override
	public void locomover() { System.out.println("voando");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alimentar() {
		System.out.println("comendo frutas");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emitirSom() { System.out.println("som ave");
		// TODO Auto-generated method stub
		
	}
public void fazerNinho() { System.out.println("fazendo ninho");
}

public String getCorPena() {
	return corPena;
}

public void setCorPena(String corPena) {
	this.corPena = corPena;
} 
}