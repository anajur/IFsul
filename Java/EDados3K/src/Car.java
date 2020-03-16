
public class Car {




		private Circulo roda;
		private Retangulo parteCima;
		private Retangulo parteBaixo;
		double area, perimetro;



		public Car(Circulo roda) {

		this.roda = roda;

		}
		public Circulo getRoda() {
		return roda;
		}
		public void setRoda(Circulo roda) {
		this.roda = roda;
		}
		public Retangulo getParteCima() {
		return parteCima;
		}
		public void setParteCima(Retangulo parteCima) {
		this.parteCima = parteCima;
		}
		public Retangulo getParteBaixo() {
		return parteBaixo;
		}
		public void setParteBaixo(Retangulo parteBaixo) {
		this.parteBaixo = parteBaixo;
		}


		public double areaTotal(){
		area=(roda.getArea()*2)+
		parteCima.CalcularArea()+
		parteBaixo.CalcularArea();



		return area;



		}

		public Double perimetroTotal(){
		perimetro=parteCima.CalcularPerimetro()+
		parteBaixo.CalcularPerimetro()
		+(roda.getPerimetro()*2);

		System.out.println("Perimetro Total do carro: "+perimetro);
		return perimetro;

		}


		
}
