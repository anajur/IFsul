package com.integrador.persistence;


	import java.sql.DriverManager;
import java.sql.SQLException;

	import com.mysql.jdbc.Connection;

	public class ConexaoMysql {
		
	
		
		private String ip;
		private String porta;
		private String nomeBD;
		private String login;
		private String senha;
			private Connection conexao;
		
		public ConexaoMysql() {
			super();
		}

		public ConexaoMysql(String ip, String porta, String nomeBD, String login, String senha) {
			super() ;
			this.ip = ip;
			this.porta = porta;
			this.login = login;
			this.senha = senha;
			this.nomeBD= nomeBD;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getPorta() {
			return porta;
		}

		public void setPorta(String porta) {
			this.porta = porta;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public String getNomeBD() {
			return nomeBD;
		}
		public void setNomeBD(String nomeBD) {
			this.nomeBD=nomeBD;
			
		}
		
		public Connection getConexao() {
			return conexao;
		}
		public void setConeXao(Connection conexao) {
			this.conexao=conexao;
		}
		
		
		// ABRIR CONEXAO
		public void abrirConexao() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			//	String url="jdbc:mysql://"+ip+":"+porta+"/"+nomeBD;
				this.conexao = (Connection) DriverManager.getConnection("jdbc:mysql://"+this.ip+":"+this.porta+"/"+this.nomeBD,this.login, this.senha);
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		// FECHAR CONEXAO
		public void fecharConexao() {
			try {
				if(!this.conexao.isClosed()) {
					this.conexao.close();			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		

	}

	
	
	

