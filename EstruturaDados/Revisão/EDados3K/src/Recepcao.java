import java.util.Scanner;

public class Recepcao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner tc = new Scanner(System.in);
		Pensionista quartos[] = new Pensionista[10];
		String hospede;
		
		System.out.println("Digite o numero de estudantes");
		int n = tc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Digite o nome: ");
			String nome = tc.next();
			tc.nextLine();
			nome.toUpperCase();
			System.out.println("Digite o email: ");
			String email = tc.next();
			System.out.println("Digite o quarto: ");
			int quarto = tc.nextInt();
			if (quartos[quarto] == null) {
				Pensionista a = new Pensionista(nome, email, quarto);

				quartos[quarto] = a;
				System.out.println("Reserva efetuada com sucesso!");
			} else {
				System.out.println("Este quarto já está alugado");
			}

		}
		for (int i = 0; i < 10; i++) {
			if (quartos[i] == null) {
				System.out.println(i + " Livre");
			} else {
				System.out.println(i + ": " + quartos[i].toString());

			}
		}
		System.out.println("Digite um nome para buscar");
		hospede = tc.next();
		hospede.toLowerCase();

		for (int i = 0; i < 10; i++) {
			if (quartos[i] != null) {

				if (quartos[i].getNome().contains(hospede)) {
					System.out.println(quartos[i].getNome() + " quarto: " + i);
				}
			}
		}
	}
}
