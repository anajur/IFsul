
public class Main {

	public static void main(String[] args) {
		Pilha pilha1 = new Pilha(5);
		Pilha pilha2 = new Pilha(5);
		Pilha pilha3 = new Pilha(5);
		
		pilha1.empilha(2);
		pilha1.empilha(5);
		pilha1.empilha(8);
		pilha1.empilha(7);
		pilha1.empilha(1);


		int topo1 = pilha1.desempilha();
		int topo7= pilha1.desempilha();
		int topo8;
		int topo5;
		int topo2;

		
		pilha2.empilha(topo1);
		topo1 = pilha2.desempilha();
		pilha3.empilha(topo1);
		pilha2.empilha(topo7);
		topo7 = pilha2.desempilha();
		pilha3.empilha(topo7);
		topo8 = pilha1.desempilha();
		pilha2.empilha(topo8);
		topo7 = pilha3.desempilha();
		pilha2.empilha(topo7);
		topo5 = pilha1.desempilha();
		pilha2.empilha(topo5);
		topo2 = pilha1.desempilha();
		pilha2.empilha(topo2);
		topo2 = pilha2.desempilha();
		pilha3.empilha(topo2);
		topo5 = pilha2.desempilha();
		pilha3.empilha(topo5);
		topo7 = pilha2.desempilha();
		pilha3.empilha(topo7);
		topo8 = pilha2.desempilha();
		pilha3.empilha(topo8);
		pilha3.imprime();
	}

}
