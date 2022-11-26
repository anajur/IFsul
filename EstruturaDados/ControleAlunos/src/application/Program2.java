package application;

import java.util.Scanner;

import controller.Menu;
import entities.Aluno;

public class Program2 {

	public static void main(String[] args) {

		Menu menu = new Menu();
		Scanner tc = new Scanner(System.in);
		int operacao;
		do {
			System.out.println("#### MENU ####\n");
			System.out.println(" 1-Adicionar\n 2-Buscar por nome\n 3-Remover\n 4-Imprimir\n 5-Fechar Menu");
			operacao = tc.nextInt();
			if (operacao > 0 && operacao <= 5) {
				switch (operacao) {
				case 1:
					System.out.println("Digite o nome do aluno: ");
					String nome = tc.next();

					System.out.println("Digite a nota: ");
					double nota = tc.nextDouble();
					if (nota >= 0) {
						Aluno aluno = new Aluno(nome.toLowerCase(), nota);
						menu.adicionar(aluno);
					} else {
						System.out.println("Nota inválida. Tente novamente.");
					}
					break;
				case 2:
					System.out.println("Digite o nome do aluno: ");
					String nomeBusca = tc.next();
					menu.buscarAluno(nomeBusca.toLowerCase());
					break;
				case 3:
					menu.remover();
					break;
				case 4:
					menu.imprimir();
					break;
				}

			} else {
				System.out.println("Digite um valor válido");
			}
		} while (operacao != 5);

		tc.close();
	}

}
