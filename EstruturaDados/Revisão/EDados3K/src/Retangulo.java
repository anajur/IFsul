
public class Retangulo {

	private double altura;
	private double largura;

	public Retangulo() {
	}

	public Retangulo(double altura, double largura) {
		this.altura = altura;
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double CalcularArea() {

		return (this.altura * this.largura);

	}

	public double CalcularDiagonal() {

		double diagonal = (altura * altura) + (largura * largura);
		diagonal = Math.sqrt(diagonal);
		return diagonal;

	}

	public double CalcularPerimetro() {

		return (this.altura * 2) + (this.largura * 2);

	}

}
