import java.util.Random;

public class Luta {

		
		private UFC desafiado;
		private  UFC desafiante;
		private int rounds;
		private boolean aprovada;
	
	
	
	public UFC getDesafiado() {
			return desafiado;
		}


		public void setDesafiado(UFC desafiado ) {
			this.desafiado = desafiado;
		}


		public UFC getDesafiante() {
			return desafiante;
		}


		public void setDesafiante(UFC desafiante) {
			this.desafiante = desafiante;
		}


		public int getRounds() {
			return rounds;
		}


		public void setRounds(int rounds) {
			this.rounds = rounds;
		}


		public boolean isAprovada() {
			return aprovada;
		}


		public void setAprovada(boolean aprovada) {
			this.aprovada = aprovada;
		}


	public void marcarLuta(UFC L1, UFC L2){
		
	
		if ( L1.getCategoria().equals(L2.getCategoria()) && 
				L1!=L2)
				{ this.setAprovada(true);
				this.setDesafiado(L1);
				this.setDesafiante(L2);
				
				
	} else { this.setAprovada(false);
				this.setDesafiado(null);
				this.setDesafiante(null);
	}
	
	}
	public void lutar() { 
		if (this.aprovada) {
			System.out.println("-----DESAFIADO-----");
		
			this.desafiado.apresenta();
			System.out.println("-----DESAFIANTE----");
			this.desafiante.apresenta();
			
			Random aleatorio = new Random();
			System.out.println("----------RESULTADO-------");
			
			int vencedor = aleatorio.nextInt(3);
			
			switch (vencedor){
			case 0: 
			System.out.println("Empatou");
			this.desafiado.empatarLuta();
			this.desafiante.empatarLuta();
			break;
			
			case 1: ///desafiado ganha
				System.out.printf("vitoria do " + this.getDesafiado().getNome());
		this.desafiado.ganharLuta();
		this.desafiante.perderLuta();
		break;
			case 2: // desafiante ganha
			
				System.out.printf("vitoria do " + this.getDesafiante().getNome());
			this.desafiado.perderLuta();
			this.desafiante.ganharLuta();
			break;
			
			
			}
			
		} else {System.out.println("A luta não pode acontecer");
		
	}
	}
}
