import java.util.Scanner;
public class MainBoletim {

	public static void main(String[] args) {
		Scanner tc= new Scanner(System.in);
		
		System.out.println("Digite o nome do aluno");
		String nome=tc.next();
	
		System.out.println("Digite a nota do primeiro semestre");
		double nota1= tc.nextDouble();
		System.out.println("Digite a nota do segundo semestre");
		double nota2= tc.nextDouble();
		
		Boletim b = new Boletim(nome, nota1,nota2);
		System.out.println("Media final: "+ b.getMedia());

		// TODO Auto-generated method stub
		
		

	}

}
