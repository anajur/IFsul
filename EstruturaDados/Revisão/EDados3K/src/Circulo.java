
public class Circulo {

	private Double raio;

	public Circulo() {
	}

	public Circulo(Double raio) {

		this.raio = raio;

	}

	public Double getPerimetro() {
		return 2 * Math.PI * this.getRaio();
	}

	public Double getArea() {
		return Math.PI * (this.getRaio() * this.getRaio());

	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

}
