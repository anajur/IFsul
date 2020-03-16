
public class ControleRemoto implements Controlador {


		
		private int volume;
		private boolean ligado;
		private boolean tocando;
		
		
		public ControleRemoto() {
			
			this.volume = 50;
			this.ligado = false;
			this.tocando = false;
		}
		
		
		

		private int getVolume() {
			return volume;
		}

		private void setVolume(int v) {
			this.volume = v;
		}

		private boolean getLigado() {
			return ligado;
		}

		private void setLigado(boolean l) {
			this.ligado = l;
		}

		private boolean getTocando(boolean tocando) {
			return tocando;
		}

		private void setTocando(boolean t) {
			this.tocando = t;
		}




		@Override
		public void ligar() {
			
			this.setLigado(true);
			// TODO Auto-generated method stub
			
		}




		@Override
		public void desligar() {
			this.setLigado(false);
			// TODO Auto-generated method stub
			
		}




		@Override
		public void abrirMenu() {
			
			if(this.getLigado()==true) {
				
			}
	System.out.println("está ligado? " + this.getLigado());
	System.out.println("tocando" + this.getTocando(tocando));
			
	System.out.println("volume " + this.getVolume());
	
	for (int i=10; i<=this.getVolume(); i+=10 ){
		
	 System.out.print("] ");
	}
		}




		@Override
		public void fecharMenu() {
			System.out.println("fechandoMenu");
			// TODO Auto-generated method stub
			
		}




		@Override
		public void maisVolume() {
			if(this.getLigado() == true) { 
				this.setVolume(this.getVolume()+5);
			}
			// TODO Auto-generated method stub
			
		}




		@Override
		public void menosVolume() {
			if(this.getLigado()==true) {
				this.setVolume(this.getVolume()-5);
			}
			// TODO Auto-generated method stub
			
		}




		@Override
		public void ligarMudo() {
			if(this.getLigado() && this.getVolume() >0) {
			this.setVolume(0);	
			}
			// TODO Auto-generated method stub
			
		}




		@Override
		public void desligarMudo() {
			if(this.getLigado() && this.getVolume() ==0) {
				this.setVolume(4);
			}
			// TODO Auto-generated method stub
			
		}




		@Override
		public void play() {
			
			if (this.getLigado() && !(this.getTocando(tocando))){
				this.setTocando(true);
			}
			// TODO Auto-generated method stub
			
		}




		@Override
		public void pause() {
			
			if(this.getLigado()&& this.getTocando(tocando))
			{ this.setTocando(false);			
		}
		
		
		}
	

		
		
	

}
