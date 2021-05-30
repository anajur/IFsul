
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arvore arvD = new Arvore('d', null, null);
		Arvore arvB = new Arvore('b', null, arvD);
		
		Arvore arvE = new Arvore('e', null, null);
		Arvore arvF = new Arvore('f', null, null);
		Arvore arvC = new Arvore('c', arvE, arvF);
		Arvore raiz = new Arvore('a', arvB, arvC);
		
		Arvore novoGalho = new Arvore('x', new Arvore('y',null,null),new Arvore('z',null,null));
		
		raiz.getEsquerda().setEsquerda(novoGalho);
		raiz.getDireita().setEsquerda(null);
		
		Arvore.imprimir(raiz);
		System.out.println("---- Ordem Simétrica ----");
		Arvore.imprimirOrdemSimetrica(raiz);
		System.out.println("----- Pós-ordem ------");
		Arvore.imprimirPosOrdem(raiz);
		
		System.out.println("Altura da árvore: " + Arvore.calculaAltura(raiz));
		System.out.println("Número de nós: " + Arvore.contaNos(raiz));

	}

}
