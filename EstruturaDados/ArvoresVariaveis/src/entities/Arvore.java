package entities;


public class Arvore {
	private String info;
	private Arvore prim;
	private Arvore prox;

	public Arvore(String info) {
		this.info = info;
		this.prim = null;
		this.prox = null;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Arvore getPrim() {
		return prim;
	}

	public void setPrim(Arvore prim) {
		this.prim = prim;
	}

	public Arvore getProx() {
		return prox;
	}

	public void setProx(Arvore prox) {
		this.prox = prox;
	}

	public static boolean estaVazia(Arvore a) {
		if (a == null)
			return true;
		else
			return false;
	}

	public static int calculaNivel(Arvore a) {
		int i = -1; 
		Arvore atual;
		for (atual = a.getPrim(); atual != null; atual = atual.getProx()) {
			int h = calculaNivel(atual);
			if (h > i)
				i = h;
		}
		return i + 1;
	}

	public static void insere(Arvore a, Arvore sub) {
		sub.setProx(a.getPrim());
		a.setPrim(sub);
	}

	public static int contaCargos(Arvore a) {
		if (a == null)
			return 0;
		else {
			int countl = contaCargos(a.getPrim());
			int countr = contaCargos(a.getProx());
			return countl + countr + 1;
		}
	}

	public static void imprime(Arvore a) {
		Arvore atual;
		System.out.println(a.getInfo());
		for (atual = a.getPrim(); atual != null; atual = atual.getProx())
			imprime(atual);
	}

	public static boolean pertence(Arvore a, String obj) {
		Arvore atual;
		
		if (a.getInfo().toLowerCase().equals(obj.toLowerCase()))
			return true;
		else {
			for (atual = a.getPrim(); atual != null; atual = atual.getProx()) {
				if (pertence(atual, obj))
					return true;
			}
			return false;
		}
	}
}
