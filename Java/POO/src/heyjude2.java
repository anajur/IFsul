import java.util.Scanner;
public class heyjude2 {

	public static void main(String[] args) {
		Scanner tc = new Scanner(System.in);
		
		String a= "don't";
		String b=" make it bad"; 
		String c= " TAKE A SAD SONG AND MAKE IT BETTER!";
		
		
		String d= "remember to";
		String e=" ";
		int a1;
System.out.println("HEY JUDE");
	
	
 System.out.println("[1]" + b + "  [2] be afraid  [3] let me down" );
		 a1=tc.nextInt();
		
		switch (a1) {
	
		case 2: b=" be afraid"; 
				c= " YOU WERE MADE TO GO OUT AND GET HER";
			break;
			
	case 3: b=" let me down"; 
			c=" YOU HAVE FOUND HER, NOW GO AND GET HER";
			break;
	}System.out.println(a+b+c);
		
		System.out.println("[1] your heart [2] your skin");
			int a2=tc.nextInt();
			
			

		switch (a2) {
		case 1: e= " let her into your heart";
		break;
		case 2: e= " let her under your skin";
		}

		

	System.out.println(d+e);
	}}
