package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.model.Pasta;
import com.integrador.model.PastaPublicacao;
import com.integrador.model.Publicacao;
import com.integrador.model.Usuario;
import com.mysql.jdbc.Statement;

public class PastaPublicacaoDAO {
	private ConexaoMysql conexao;

	public PastaPublicacaoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "bd_app", "root", "my3soul");
	}
	
	
	public PastaPublicacao salvar(PastaPublicacao pastaPublicacao) {
		// abrir conexao mysql
		this.conexao.abrirConexao();
		// criar a instrucao sql de insert
		String sqlInsert = "INSERT INTO pasta_publicacao VALUES(null, ?, ?)";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			prepare.setLong(1, pastaPublicacao.getPublicacao().getIdPublicacao());
			prepare.setLong(2, pastaPublicacao.getPasta().getIdPasta());
			
			
		
			
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				pastaPublicacao.setIdPastaPublicacao(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}
		return pastaPublicacao;
	}
	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM pasta_publicacao WHERE id_pasta_publicacao=?";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);
			prepare.setLong(1, id);
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}
	}
	

	public List<PastaPublicacao> listarPublicacaoPasta(long idPasta){
		this.conexao.abrirConexao();
		List<PastaPublicacao> listaPastas=new ArrayList<PastaPublicacao>();
		PastaPublicacao pp=null;
		String sqlBuscarTodos= "SELECT * FROM pasta_publicacao WHERE id_pasta=?";
		try {
		PreparedStatement prepare =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
		prepare.setLong(1, idPasta);
		ResultSet rs=prepare.executeQuery();
		
		
		while(rs.next()) {pp = new PastaPublicacao();
		

		pp.setIdPastaPublicacao(rs.getLong("id_pasta_publicacao"));
	
		
		PublicacaoDAO pDAO =new PublicacaoDAO();
		Publicacao p= pDAO.buscarPorId(rs.getLong("id_publicacao"));
		pp.setPublicacao(p);
		pp.setPublicacao(p);
			PastaDAO uDAO= new PastaDAO();
		Pasta u= uDAO.buscarPorId(rs.getLong("id_pasta"));
		pp.setPasta(u);
		
			
			listaPastas.add(pp);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaPastas;
	}
	public List<PastaPublicacao> buscarTodos(){
		this.conexao.abrirConexao();
		List<PastaPublicacao> listaPastas=new ArrayList<PastaPublicacao>();
		PastaPublicacao pasta=null;
		String sqlBuscarTodos= "SELECT * FROM pasta_publicacao";
		try {
		PreparedStatement prepare =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
		ResultSet rs=prepare.executeQuery();
		
		while(rs.next()) {
			pasta = new PastaPublicacao();
			
	
			
		pasta.setIdPastaPublicacao(rs.getLong("id_pasta_publicacao"));
	
		
		PublicacaoDAO pDAO =new PublicacaoDAO();
		Publicacao p= pDAO.buscarPorId(rs.getLong("id_publicacao"));
		pasta.setPublicacao(p);
		pasta.setPublicacao(p);
			PastaDAO uDAO= new PastaDAO();
		Pasta u= uDAO.buscarPorId(rs.getLong("id_pasta"));
		pasta.setPasta(u);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaPastas;
	}

	
}
