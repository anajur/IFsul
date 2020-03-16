
public class Livro09b implements Publicação09b{


		
		
		private String titulo;
	private	String autor;
		private int pgtotal;
		private int pgatual;
		private  Pessoa09b leitor;
		private boolean aberto;
		
		
		
		
public String 	detalhes(){
	return "Livro{" + "titulo: " + titulo + "\n  autor: " + autor +
			"\n totalPaginas " + pgtotal + "\n paginaAtual " + pgatual +
			" \n aberto: " + aberto + "\n leitor: " +  this.getLeitor().getNome() + "     }";}
			
			

	public Livro09b(String titulo, String autor, int pgtotal, int pgatual, Pessoa09b leitor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.pgtotal = pgtotal;
		this.aberto = false;
		this.pgatual = 0;
		this.leitor = leitor;
	
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPgtotal() {
		return pgtotal;
	}

	public void setPgtotal(int pgtotal) {
		this.pgtotal = pgtotal;
	}

	public int getPgatual() {
		return pgatual;
	}

	public void setPgatual(int pgatual) {
		this.pgatual = pgatual;
	}

	public Pessoa09b getLeitor() {
		return leitor;
	}

	public void setLeitor(Pessoa09b leitor) {
		this.leitor = leitor;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}



	@Override
	public void abrir() {
this.setAberto(true);
		// TODO Auto-generated method stub
		
	}



	@Override
	public void fechar() { this.setAberto(false);
		// TODO Auto-generated method stub
	
	
		
	}



	@Override
	public void folhear(int p) {
		if(this.aberto==true ) { if(p<pgtotal) {
			
		this.pgatual = p + pgatual; } else { System.out.println("livro acabou");}} else {System.out.println("abra o livro primeiro para folhear");}
		// TODO Auto-generated method stub
		
	}



	@Override
	public void avançarPag() {
		if(this.aberto==true) {
		this.pgatual++; } else {System.out.println("abra o livro primeiro para avançar");}
		// TODO Auto-generated method stub
		
	}



	@Override
	public void voltarPag() {
		if(this.aberto==true) {
		this.pgatual--; } else {System.out.println("abra o livro primeiro para voltar");}
		// TODO Auto-generated method stub
		
	}
	
	
	
		// TODO Auto-generated method stub

	

}
