
public class Pilha {
	private int[] elementos;
	private int topo = 0;

	public Pilha(int tamanho) {
		this.elementos = new int[tamanho];
	}

	public Pilha() {
		super();
	}

	public int[] getElementos() {
		return elementos;
	}

	public void setElementos(int[] elementos) {
		this.elementos = elementos;
	}

	public int getTopo() {
		return topo;
	}

	public void setTopo(int topo) {
		this.topo = topo;
	}

	public boolean estaVazia() {
		if (elementos[0] == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean estaCheia() {
		if (this.getTopo() + 1 == elementos.length) {
			return true;
		} else {
			return false;
		}
	}

	public void empilha(int e) {

		int contador = 0;
		if (this.estaCheia()) {
			System.out.println("A pilha já está cheia.");
		} else {
			for (int i = 0; i < elementos.length; i++) {
				if (this.getElementos()[i] != 0) {
					contador += 1;
				}
			}
			this.setTopo(contador);

			this.getElementos()[contador] = e;
		}

	}

	public int desempilha() {
		int contador = 0;
		for (int i = 0; i < elementos.length; i++) {
			if (this.getElementos()[i] != 0) {
				contador += 1;
			}
		}
		int removido = this.getElementos()[contador - 1];
		this.getElementos()[contador - 1] = 0;
		this.setTopo(contador - 2);

		return removido;
	}

	public int elementoTopo() {
		return this.getElementos()[this.getTopo()];
	}

	public void imprime() {

		if (this.estaVazia()) {
			System.out.println("A lista está vazia.");
		} else {

			for (int i = this.getTopo(); i >= 0; i--) {

				System.out.println(this.getElementos()[i]);

			}
		}
	}

}
