
public class Banco {
		
		
		public	int numConta ;
		protected String tipo;
		private String dono;
		private float saldo;
		private	boolean status;
		
		public void estado() {
			System.out.println("Conta " + this.getNumConta());
			System.out.println("Dono: " + this.getDono());
			System.out.println("Tipo " + this.getTipo());
			System.out.println("Saldo: " + this.getSaldo());
			System.out.println("status " + this.status);
		}
		
	
		
		
		public void abrirConta(String t) {
			setTipo(t);
			this.setStatus(true);
			if (t=="CC") {
				this.setSaldo(50);
			} else if (t=="CP") { 
				this.setSaldo(150);
			}
		
	}
		public void fecharConta() { 
			if (this.getSaldo()==0) { this.setStatus(false); System.out.println("fechou");
			
			}else if (this.getSaldo()<0) { System.out.println("VOCE DEVE");} 
			else if (this.getSaldo()>0) { System.out.println("AINDA TEM MONEY");}
}

		
		public void depositar (float v) {
			if (this.getStatus() == true) {
				
			this.setSaldo(this.getSaldo()+v);	
			System.out.println("deosito realizado");}
			else{ System.out.println("NAO PODE DEPOSITAR");
}}


		public void sacar (float v) {
			if (this.getStatus() ==true ) {
				if(this.getSaldo()>=v) {
					this.setSaldo(this.getSaldo()-v);
					System.out.println("Saque realizado" + this.getDono());
			}
			
						else  {
						System.out.println("SEM SALDO");}
			} else { System.out.println("conta fechada");
}
		}
		
		public void Pagar() {
			int v=0;
			if (this.getTipo()=="CC") { v=12;} 
			else if (this.getTipo()=="CP") { v=20;}
			
			if(this.getStatus()==true) {
				this.setSaldo(this.getSaldo()-v);
				System.out.println("mensalidade paga");} else 
			{System.out.println("SEM SALDO");}
			
				
		}	
		
		public Banco() {
			
			this.saldo = 0;
			this.status = false;
		}
		
		
		
		
		

public int getNumConta() {
			return numConta;
		}




		public void setNumConta(int numConta) {
			this.numConta = numConta;
		}




		public String getTipo() {
			return tipo;
		}




		public void setTipo(String tipo) {
			this.tipo = tipo;
		}




		public String getDono() {
			return dono;
		}




		public void setDono(String dono) {
			this.dono = dono;
		}




		public float getSaldo() {
			return saldo;
		}




		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}




		public boolean getStatus() {
			return status;
		}




		public void setStatus(boolean status) {
			this.status = status;
		}





 


 
		// TODO Auto-generated method stub
		
	

}
