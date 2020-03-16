
class cachorro extends lobo {

	@Override
	public void emitirSom() {
		System.out.println("AU AU AU");}
	
		
		
		
		
		public void reagir (String frase) {
			
			if(frase=="comida" || frase== "olá") {
			System.out.println("abanar e latir");	
			} else { System.out.println("Rosnar");}
		}
		
		public void reagir (int hora, int min) {
			if(hora<12) {System.out.println("abanar");}
			
			else if (hora>=18) { System.out.println("ignorar");}
	
		 else  { System.out.println("Abanar e latir");}}
		
		public void reagir (boolean dono) {
			if(dono) {
				System.out.println("abanar");}
			else {System.out.println("rosnar e latir");
			}
			
		}
			
		
		
		
		
		public void reagir (int idade, float peso) {
			
			if(idade<5) { 
				if(peso<10) { System.out.println("abanar");}
			else { System.out.println("latir");}}
				
			else if (peso<10) { System.out.println("rosnar"); 
			} else { System.out.println("ignorar");
			}

		}
}
