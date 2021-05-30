
public class Arvore {
	private Object info;
	private Arvore esquerda;
	private Arvore direita;

	public Arvore() {
		super();
	}

	public Arvore(Object info, Arvore esquerda, Arvore direita) {
		super();
		this.info = info;
		this.esquerda = esquerda;
		this.direita = direita;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public Arvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Arvore esquerda) {
		this.esquerda = esquerda;
	}

	public Arvore getDireita() {
		return direita;
	}

	public void setDireita(Arvore direita) {
		this.direita = direita;
	}

	public static boolean estaVazia(Arvore a) {
		if (a == null) {
			return true;
		} else {
			return false;
		}
	}

	public static void imprimir(Arvore a) {
		if (!estaVazia(a)) {
			System.out.println(a.info);
			imprimir(a.esquerda);
			imprimir(a.direita);
		}
	}
	
	public static void imprimirOrdemSimetrica(Arvore a) {
		if (!estaVazia(a)) {
			imprimir(a.esquerda);
			System.out.println(a.info);
			imprimir(a.direita);
		}
	}

	public static void imprimirPosOrdem(Arvore a) {
		if (!estaVazia(a)) {
			imprimir(a.esquerda);
			imprimir(a.direita);			
			System.out.println(a.info);

		}
	}
	public static int contaNos(Arvore a) {
	    if (a == null) return 0;
	    else {          
	        int countl = contaNos (a.getEsquerda());         
	        int countr = contaNos (a.getDireita()); 
	        return countl + countr + 1;   
	    }
		}
		
	
	public static int calculaAltura(Arvore a) {
		if ( a == null)  { return -1; }
		else {
			
			int l = calculaAltura (a.getEsquerda());
			int r = calculaAltura(a.getDireita());
			return (r > l ? r: l) + 1;
		}

	}
	
}
