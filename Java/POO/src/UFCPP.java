
public class UFCPP {

	public static void main(String[] args) {
		
		
 UFC L []=	new UFC [6];
 
L[0] = new UFC ("Paulo Brioche", "França", 31, 1.75f, 68.9f, 11, 2 ,1);
 
L[1] = new UFC("Putscript", "Brasil", 29, 1.68f, 57.8f, 14,2,3);

L[2] = new UFC ("Snapshot", "EUA", 35,1.65f, 80.9f, 12, 2,1);

L[3] = new UFC ("Dead Code", "Alasca", 28,1.93f,81.6f,12,0,2);

L[4] = new UFC("Jones Indiano", "Índia", 37, 1.70f, 119.3f,5,4,3);

L[5] = new UFC("Erik", "Brasil", 30, 1.81f, 105.7f, 12,2,4);


Luta UFC01 = new Luta();
UFC01.marcarLuta(L[2], L[3]);
UFC01.lutar();






	}

}
