
public class bolsista11a extends aluno11a {
	
	private float bolsa;
	
	
public void	renovarBolsa() {
	System.out.println("renovando bolsa de " + this.nome);
}

@Override
public void pagarMens() {
	
	System.out.println("pagando mensalidade bolsista " + this.nome);
}

public float getBolsa() {
	return bolsa;
}

public void setBolsa(float bolsa) {
	this.bolsa = bolsa;
}


}
