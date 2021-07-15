package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.model.Flashcard;
import com.integrador.model.Pasta;
import com.integrador.model.Usuario;
import com.integrador.model.UsuarioSegueUsuario;
import com.mysql.jdbc.Statement;

public class UsuarioSegueUsuarioDAO {

	private ConexaoMysql conexao;

	public UsuarioSegueUsuarioDAO() {

		this.conexao = new ConexaoMysql("localhost", "3306","bd_app", "root", "my3soul");
	}

	public UsuarioSegueUsuario salvar(UsuarioSegueUsuario usuarioSegueUsuario) {
		this.conexao.abrirConexao();

		String sqlInsert = "INSERT INTO usuario_segue VALUES(null, ?, ?)";

		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			prepare.setLong(1, usuarioSegueUsuario.getSeguido().getIdUsuario());
			prepare.setLong(2, usuarioSegueUsuario.getSeguidor().getIdUsuario());

			prepare.executeUpdate();
			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				usuarioSegueUsuario.setIdUsuarioSegue(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}

		return usuarioSegueUsuario;
	}

//	public UsuarioSegueUsuario ContarSeguidores(Long id) {
//		this.conexao.abrirConexao();
//
//		String sqlInsert = "SELECT COUNT * FROM usuario_segue WHERE id_usuario_seguido=? ";
//
//		try {
//			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
//					Statement.RETURN_GENERATED_KEYS);
//			prepare.setLong(1, usuario.getSeguido().getIdUsuario());
//
//			prepare.executeUpdate();
//			ResultSet rs = prepare.getGeneratedKeys();
//			if (rs.next()) {
//				long id = rs.getLong(1);
//				usuarioSegueUsuario.setIdUsuarioSegue(id);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			// fechar a conexao com mysql
//			this.conexao.fecharConexao();
//		}
//
//		return usuarioSegueUsuario;
//	}
	public UsuarioSegueUsuario ContarSeguidores(long id){
		this.conexao.abrirConexao();
	//	List<UsuarioSegueUsuario> seguidores=new ArrayList<UsuarioSegueUsuario>();
		UsuarioSegueUsuario usuario=null;
		String sqlBuscarTodos= "SELECT COUNT(*) FROM usuario_segue WHERE id_usuario_seguido=?";
		try {
		PreparedStatement prepare =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
		prepare.setLong(1, id);
		ResultSet rs=prepare.executeQuery();
		
		
		while(rs.next()) {
			
//			usuario = new UsuarioSegueUsuario();
//		usuario.setIdUsuarioSegue(rs.getLong("id_usuario_segue"));
//		UsuarioDAO uDAO= new UsuarioDAO();
//		Usuario a= uDAO.buscarPorId(rs.getLong("id_usuario_seguidor"));
//		usuario.setSeguido(a);
//			
//		Usuario u= uDAO.buscarPorId(rs.getLong("id_usuario_seguido"));
//		usuario.setSeguido(u);
//			
//		
	
			//seguidores.add(usuario);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void deixarDeSeguir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM usuario_segue WHERE id_usuario_seguido=?";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);
			prepare.setLong(1, id);
			prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}}
	
//	public List<UsuarioSegueUsuario> listarSeguidores(long idUsuario){
//	this.conexao.abrirConexao();
//	List<UsuarioSegueUsuario> seguidores=new ArrayList<UsuarioSegueUsuario>();
//	UsuarioSegueUsuario usuario=null;
//	String sqlListarSeguidores= "SELECT seguidor FROM usuario_segue WHERE id_usuario=? ";
//	try {
//	PreparedStatement prepare =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlListarSeguidores);
//	prepare.setLong(1, idUsuario);
//	ResultSet rs=prepare.executeQuery();
//	
//	
//	while(rs.next()) {
//		usuario= new UsuarioSegueUsuario();
//		
//		UsuarioDAO uDAO= new UsuarioDAO();
//		Usuario u= uDAO.buscarPorId(rs.getLong("id_usuario_seguidor"));
//		u.uu);
//		
//		pasta.setIdPasta(rs.getLong("id_pasta"));
//		pasta.setCategoria(rs.getString("categoria"));
//		pasta.setTitulo(rs.getString("titulo"));
//		
//		seguidores.add(usuario);
//		
//	}
//	}
//	catch(SQLException e) {
//		e.printStackTrace();
//	}
//
//return listaPastas;
//}
}
