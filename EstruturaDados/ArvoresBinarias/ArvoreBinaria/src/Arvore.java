
public class Arvore {
	private int info;
	private Arvore esquerda;
	private Arvore direita;

	public Arvore() {
		super();
	}

	public Arvore(int info, Arvore esquerda, Arvore direita) {
		super();
		this.info = info;
		this.esquerda = esquerda;
		this.direita = direita;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
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
			imprimir(a.esquerda);
			System.out.println(a.info);
			imprimir(a.direita);
		}
	}

	public static Arvore busca(Arvore a, int obj) {
		if (estaVazia(a)) {
			return null;
		}
		if (a.info > obj) {
			return busca(a.esquerda, obj);
		} else if (a.info < obj) {
			return busca(a.direita, obj);
		} else {
			return a;
		}
	}

	public static Arvore insere(Arvore a, int obj) {
		if (estaVazia(a))
			a = new Arvore(obj, null, null);
		else if (a.info > obj)
			a.setEsquerda(insere(a.getEsquerda(), obj));
		else
			a.setDireita(insere(a.getDireita(), obj));
		return a;
	}

	public static Arvore retira(Arvore a, int obj) {
		if (estaVazia(a))
			return null;
		else if (a.getInfo() > obj)
			a.setEsquerda(retira(a.getEsquerda(), obj));
		else if (a.getInfo() < obj)
			a.setDireita(retira(a.getDireita(), obj));
		else {
			if ((a.getEsquerda() == null) && a.getDireita() == null)
				a = null;
			else if (a.getEsquerda() == null)
				a = a.getDireita();
			else if (a.getDireita() == null)
				a = a.getEsquerda();
			else {
				Arvore t = a.getEsquerda();
				while (t.getDireita() != null)
					t = t.getDireita();
				a.setInfo(t.getInfo());
				t.setInfo(obj);
				a.setEsquerda(retira(a.getEsquerda(), obj));
			}

		}
		return a;

	}

	public static int contaNos(Arvore a) {
		if (a == null)
			return 0;
		else {
			int countl = contaNos(a.getEsquerda());
			int countr = contaNos(a.getDireita());
			return countl + countr + 1;
		}
	}

	public static int contaNosDireita(Arvore a) {
		if (a == null)
			return 0;
		else {

			int countr = contaNos(a.getDireita());
			return countr;
		}
	}

	public static int contaNosEsquerda(Arvore a) {
		if (a == null)
			return 0;
		else {
			int count = contaNos(a.getEsquerda());
			return count;
		}
	}

	public static int menorElemento(Arvore a) {
		int menor = a.getInfo();

		if (a.getEsquerda() != null) {
			menor = menorElemento(a.getEsquerda());
		}

		return menor;
	}

	public static int maiorElemento(Arvore a) {
		int maior = a.getInfo();

		if (a.getDireita() != null) {
			maior = maiorElemento(a.getDireita());
		}

		return maior;
	}

	public static void balancea(Arvore a) {

		while (Arvore.contaNosDireita(a) - Arvore.contaNosEsquerda(a) >= 1
				|| Arvore.contaNosEsquerda(a) - Arvore.contaNosDireita(a) >= 1) {

			if (contaNosDireita(a) >= contaNosEsquerda(a) + 1) {

				insere(a.getEsquerda(), a.getInfo());
				int menor = menorElemento(a.getDireita());

				a.setInfo(menor);
				retira(a, menor);
			}

			if (contaNosEsquerda(a) >= contaNosDireita(a) + 1) {

				insere(a.getDireita(), a.getInfo());
				int maior = maiorElemento(a.getEsquerda());

				a.setInfo(maior);
				retira(a, maior);

			}

		}

	}
}
