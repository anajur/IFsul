package application;

import java.util.Scanner;

import entities.Arvore;

public class Main {

	public static void main(String[] args) {
		System.out.print("Bem Vinda(o) ao Egito Antigo!");

		StringBuilder linha = new StringBuilder("");
		StringBuilder piramide = new StringBuilder("");

		for (int j = 0; j < 5 * 2 - 1; j++)
			piramide.append('^'); // base

		linha.append(piramide);
		int ini = 1, fim = 2;

		while (ini != fim) {
			ini = linha.indexOf("^");
			fim = linha.lastIndexOf("^");

			linha.replace(ini, ini + 1, " ");
			linha.replace(fim, fim + 1, " ");

			piramide.insert(0, linha + "\n");
		}
		System.out.print(piramide);

		Arvore raiz = new Arvore("Faraó");
		Arvore clero = new Arvore("Clero");
		Arvore ministro = new Arvore("Ministro");
		Arvore chefeArsenal = new Arvore("ChefeArsenal");
		Arvore sacerdote = new Arvore("Sacerdote");
		Arvore escriba = new Arvore("Escriba");
		Arvore mercador = new Arvore("Mercador");
		Arvore chefeMilitar = new Arvore("ChefeMilitar");
		Arvore soldado = new Arvore("Soldado");
		Arvore funcionario = new Arvore("Funcionario");
		Arvore escravo = new Arvore("Escravo");
		Arvore baixoClero = new Arvore("BaixoClero");
		Arvore guarda = new Arvore("Guarda");
		Arvore campones = new Arvore("Camponês");
		Arvore intendente = new Arvore("Intendente");
		Arvore.insere(raiz, clero);
		Arvore.insere(raiz, ministro);
		Arvore.insere(raiz, chefeArsenal);
		Arvore.insere(raiz, intendente);
		Arvore.insere(clero, sacerdote);
		Arvore.insere(ministro, funcionario);
		Arvore.insere(ministro, escriba);
		Arvore.insere(funcionario, guarda);
		Arvore.insere(escriba, campones);
		Arvore.insere(intendente, mercador);
		Arvore.insere(chefeMilitar, soldado);
		Arvore.insere(campones, escravo);
		Arvore.insere(sacerdote, baixoClero);
		Arvore.insere(chefeArsenal, chefeMilitar);

		Scanner teclado = new Scanner(System.in);

		int escolha;

		do {
			System.out.println("\nMenu \n" + "1 - Exibir Hierarquia Social \n" + "2 - Exibir números de cargos \n"
					+ "3 - Exibir número de níveis hierárquicos \n"
					+ "4 - Verificar se cargo existe na hierarquia social\n" + "5 - Fechar menu.\n");

			escolha = teclado.nextInt();
			switch (escolha) {
			case 1:
				Arvore.imprime(raiz);
				break;
			case 2:
				System.out.println("O número de cargos existentes é " + Arvore.contaCargos(raiz));

				break;

			case 3:
				System.out.println("O número de níveis hierárquicos é " + Arvore.calculaNivel(raiz));

				break;
			case 4:
				System.out.println("Digite o cargo: ");
				String cargo = teclado.next();
				if (Arvore.pertence(raiz, cargo)) {
					System.out.println("Cargo existente.");

				} else {
					System.out.println("Cargo não existe.");
				}

				break;

			default:
				break;

			}

		} while (escolha != 5);

		teclado.close();
	}

}
