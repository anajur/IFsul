package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.model.Flashcard;
import com.integrador.model.Pasta;
import com.integrador.model.Usuario;
import com.mysql.jdbc.Statement;

public class FlashcardDAO {

	private ConexaoMysql conexao;

	public FlashcardDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306","bd_app", "root", "my3soul");
	}

	

	public Flashcard adicionar(Flashcard flashcard) {
		// abrir conexao mysql
		this.conexao.abrirConexao();
		// criar a instrucao sql de insert
		String sqlInsert = "INSERT INTO flashcard VALUES(null,?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			prepare.setString(1, flashcard.getCategoria());
			prepare.setString(2, flashcard.getPergunta());
			prepare.setString(3, flashcard.getResposta1());
			prepare.setString(4, flashcard.getResposta2());
			prepare.setString(5, flashcard.getResposta3());
			prepare.setLong(6, flashcard.getUsuarioAdiciona().getIdUsuario());
			

			// executar essa instrucao
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				flashcard.setIdFlashcard(id);
				System.out.println("adicionado!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			System.out.println("há algo errado");
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}
		return flashcard;
	}
	
	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM flashcard WHERE id_fc=?";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);
			prepare.setLong(1, id);
			prepare.executeUpdate();
			System.out.println("excluido!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void editar(Flashcard flashcard) {
		// abrir conexao
		this.conexao.abrirConexao();
		// criar a instrucao sql
		String sqlUpdate = "UPDATE flashcard SET categoria=?, pergunta=?, resposta_1=?, resposta_2=?, resposta_3=?, id_usuario=? WHERE id_fc=?";
		// preparar a instrucao para ser executada
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			prepare.setString(1, flashcard.getCategoria());
			prepare.setString(2, flashcard.getPergunta());
			prepare.setString(3, flashcard.getResposta1());
			prepare.setString(4, flashcard.getResposta2());
			prepare.setString(5, flashcard.getResposta3());
			prepare.setLong(6, flashcard.getUsuarioAdiciona().getIdUsuario());
			prepare.setLong(7, flashcard.getIdFlashcard());
			
			// executar a instrucao
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// fechar conexao
			this.conexao.fecharConexao();
		}
	}

	public List<Flashcard> buscarTodos(){
		this.conexao.abrirConexao();
		List<Flashcard> listaFlashcards=new ArrayList<Flashcard>();
		Flashcard flashcard=null;
		String sqlBuscarTodos= "SELECT * FROM flashcard";
		try {
		PreparedStatement prepare =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
		ResultSet rs=prepare.executeQuery();
		
		while(rs.next()) {
			flashcard= new Flashcard();
			flashcard.setIdFlashcard(rs.getLong("id_fc"));
			flashcard.setCategoria(rs.getString("categoria"));
			flashcard.setPergunta(rs.getString("pergunta"));
			flashcard.setResposta1(rs.getString("resposta_1"));
			flashcard.setResposta2(rs.getString("resposta_2"));
			flashcard.setResposta3(rs.getString("resposta_3"));
			
			UsuarioDAO uDAO= new UsuarioDAO();
			Usuario u= uDAO.buscarPorId(rs.getLong("id_usuario"));
			flashcard.setUsuarioAdiciona(u);
			System.out.println(rs.getLong("id_usuario"));
			
			
			
			
			
			listaFlashcards.add(flashcard);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaFlashcards;
	}
	public Flashcard buscarPorId(long id) {
		this.conexao.abrirConexao();
		Flashcard flashcard = null;
		String sqlBuscarPorId="SELECT * FROM flashcard WHERE id_fc=?";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			prepare.setLong(1, id);
			
			ResultSet rs = prepare.executeQuery();
			
			if(rs.next()) {
				// EXISTE A LINHA E TEMOS QUE CONVERTER A LINHA PARA UM OBJETO USUARIO
				flashcard = new Flashcard();
				flashcard.setIdFlashcard(rs.getLong("id_fc"));
				flashcard.setCategoria(rs.getString("categoria"));
				flashcard.setResposta1(rs.getString("resposta_1"));
				flashcard.setResposta2(rs.getString("resposta_2"));
				flashcard.setResposta3(rs.getString("resposta_3"));
//				flashcard.setUsuarioAdiciona(rs.getLong("id_usuario"));

				UsuarioDAO uDAO= new UsuarioDAO();
				Usuario u= uDAO.buscarPorId(rs.getLong("id_usuario"));
				flashcard.setUsuarioAdiciona(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		return flashcard;
		
	}
	
	public List<Flashcard> buscarFlashcardPorIdUsuario(long idUsuario){
		this.conexao.abrirConexao();
		List<Flashcard> listaPastas=new ArrayList<Flashcard>();
		Flashcard flashcard=null;
		String sqlBuscarFlashcards= "SELECT * FROM flashcard WHERE id_usuario=?";
		try {
		PreparedStatement prepare =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarFlashcards);
		prepare.setLong(1, idUsuario);
		ResultSet rs=prepare.executeQuery();
		
		
		while(rs.next()) {
			
			
			flashcard = new Flashcard();
			UsuarioDAO uDAO= new UsuarioDAO();
			Usuario u= uDAO.buscarPorId(rs.getLong("id_usuario"));
			flashcard.setUsuarioAdiciona(u);
			flashcard.setIdFlashcard(rs.getLong("id_fc"));
			flashcard.setCategoria(rs.getString("categoria"));
			flashcard.setResposta1(rs.getString("resposta_1"));
			flashcard.setResposta2(rs.getString("resposta_2"));
			flashcard.setResposta3(rs.getString("resposta_3"));

		
			
			listaPastas.add(flashcard);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaPastas;
	}
	

	

}
