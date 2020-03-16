
public class Livropp09b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pessoa09b [] p = new Pessoa09b[2];
		
		Livro09b [ ] l = new Livro09b [3];
		
		
	p[0]= new Pessoa09b("Elinor",35,"F");
	
	p[1]= new Pessoa09b("Philip",40,"M");
	
	l[0]= new Livro09b ("Contraponto", "Aldous Huxley", 700, 0, p[1]);
	
	
	l[1]= new Livro09b ("Tulipa Negra", "Alexandre Dumas", 120, 0, p[0]);

	
	l[2]= new Livro09b ("E MORREU", "DIDI", 77, 0, p[1]);
	
	
	
l[1].abrir();

l[1].folhear(140);
l[1].avançarPag();

	
	System.out.printf(l[1].detalhes() ); 
	
	
	}

}
