import java.util.Scanner;

public class MainFormas {

	public static void main(String[] args) {

		Scanner tc = new Scanner(System.in);

		// CIRCULO
		System.out.println("Digite o raio da circulo");
		double raio = tc.nextDouble();
		Circulo c = new Circulo(raio);
		System.out.println("AREA = " + c.getArea());
		System.out.println("PERIMETRO = " + c.getPerimetro());

		// RETANGULO
		System.out.println("Digite a altura do retângulo: ");
		double altura = tc.nextDouble();
		System.out.println("Digite a largura do retângulo: ");
		double largura = tc.nextDouble();

		Retangulo r = new Retangulo(altura, largura);

		System.out.println("AREA = " + r.CalcularArea());
		System.out.println("DIAGONAL = " + r.CalcularDiagonal());
		System.out.println("PERIMETRO = " + r.CalcularPerimetro());

		// TODO Auto-generated method stub

	}

}
