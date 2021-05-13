import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matriz[][] = new int[4][4];
		Random gerador = new Random();
		int x = 0, y = 0;
		Scanner tc = new Scanner(System.in);
		int o = 0, a = 0, b = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				matriz[i][j] = 0;
			}
		}

		while (o < 6) {
			a = gerador.nextInt(4);
			b = gerador.nextInt(4);
			matriz[a][b] = 1;
			o++;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Informe as coordenadas x e y: ");
			x = tc.nextInt();
			y = tc.nextInt();

			if (matriz[x][y] == 1) {
				System.out.println("FOGO!!!");
				matriz[x][y] = 2;

			} else {
				System.out.println("AGUA");

			}
			for (i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					System.out.print(matriz[i][j] + " ");
				}

				System.out.println(" ");
			}
		}
	}

}
