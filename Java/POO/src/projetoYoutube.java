
public class projetoYoutube {

	public static void main(String[] args) {
		
		video14b v[] = new video14b[3];
		
		v[0] = new video14b ( "Depois");
		v[1] = new video14b ( " aula 2");
		v[2] = new video14b ( " filme");
		
		gafanhoto g[] = new gafanhoto[2];
		
		g[0] = new gafanhoto ("ale",15, "f", "alee" );
		
		
		g[1] = new gafanhoto ("luis",22, "m", "lu" );

		visualizacao vis = new visualizacao(g[0], v[2]);
		
		System.out.println(vis.toString());
		// TODO Auto-generated method stub

	}

}
