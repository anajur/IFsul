
public class people {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Banco p1 = new Banco();
		p1.setNumConta(121);
		p1.setDono("Jabira");
		p1.abrirConta("CC");
		p1.depositar(300);
		p1.fecharConta();
		p1.estado();
		
		
		Banco p2 = new Banco();
		p2.setDono("Creuni");
		p2.setNumConta(122);
		p2.abrirConta("CP");
		p2.depositar(500);

		p2.estado();
		
	}

}
