
public class visualizacao {

	private gafanhoto espectador;
	private video14b filme;
	public visualizacao(gafanhoto espectador, video14b filme) {
		super();
		this.espectador = espectador;
		this.filme = filme;
		this.filme.setViews(this.filme.getViews()+1);
		this.espectador.setTotAssistindo(this.espectador.getTotAssistindo()+1);
	}
	
	public void avaliar() {
		this.filme.setAvaliacao(5);
	}
	
	public void avaliar(int nota) {
		this.filme.setAvaliacao(nota);
	}
	
	public void avaliar (float po) {
		int tot=0;
		if (po <= 20) {
			tot = 3;
		} else if (po <=50)
		{ tot = 5;}
		
		else if (po<=90) {
			tot =8;
		} else {tot=10;}
		this.filme.setAvaliacao(tot);
		
	}
	public gafanhoto getEspectador() {
		return espectador;
	}
	public void setEspectador(gafanhoto espectador) {
		this.espectador = espectador;
	}
	public video14b getFilme() {
		return filme;
	}
	public void setFilme(video14b filme) {
		this.filme = filme;
	}
	@Override
	public String toString() {
		return "visualizacao [espectador=" + espectador + ", filme=" + filme + "]";
	}
	
	
}
