
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arvore arv = new Arvore(6, null, null);
		/*
		 * se os valores abaixos fossem inseridos fora de ordem, o resultado seria o
		 * mesmo ???
		 */
		Arvore.insere(arv, 2);
		Arvore.insere(arv, 8);
		Arvore.insere(arv, 1);
		Arvore.insere(arv, 4);
		Arvore.insere(arv, 3);

		System.out.println("Imprimindo a árvore:");
		Arvore.imprimir(arv);

		System.out.println("Imprimindo a galho esquerdo:");
		Arvore.imprimir(arv.getEsquerda());
		Arvore t = Arvore.busca(arv, 2);
		System.out.println("Imprimindo com raiz 2:");
		Arvore.imprimir(t);

		Arvore.retira(arv, 2);
		System.out.println("Imprimindo a árvore sem o 2:");
		Arvore.imprimir(arv);

		System.out.println("Nós à esquerda: " + Arvore.contaNosEsquerda(arv));
		System.out.println("Nós à direita: " + Arvore.contaNosDireita(arv));
		Arvore.balancea(arv);
		System.out.println("Nós à esquerda: " + Arvore.contaNosEsquerda(arv));
		System.out.println("Nós à direita: " + Arvore.contaNosDireita(arv));
		System.out.println("Imprimindo a árvore:");
		Arvore.imprimir(arv);

	}

}
