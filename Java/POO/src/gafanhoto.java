
public class gafanhoto extends Pessoa14b {

private String login;
private int totAssistindo;



public gafanhoto(String nome, int idade, String sexo, String login) {
	super(nome, idade, sexo);
	this.login = login;
	this.totAssistindo = 0;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public int getTotAssistindo() {
	return totAssistindo;
}
public void setTotAssistindo(int toAssistindo) {
	this.totAssistindo = toAssistindo;
}
@Override
public String toString() {
	return "gafanhoto [login=" + login + 
			super.toString()+"\n toAssistindo=" + totAssistindo + "]";
}



		// TODO Auto-generated constructor stub
	}

