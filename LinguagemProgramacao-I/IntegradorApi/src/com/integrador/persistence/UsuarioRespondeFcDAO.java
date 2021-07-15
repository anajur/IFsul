package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.UsuarioRespondeFc;
import com.mysql.jdbc.Statement;

public class UsuarioRespondeFcDAO {

	private ConexaoMysql conexao;
	public UsuarioRespondeFcDAO( ConexaoMysql conexao) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "my3soul", "bd_app");
	}
		public UsuarioRespondeFc salvar(UsuarioRespondeFc usuarioRespondeFc) {
			// abrir conexao mysql
			this.conexao.abrirConexao();
			// criar a instrucao sql de insert
			String sqlInsert = "INSERT INTO usuario_flashcard VALUES(null, ?, ?)";
			try {
				PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
						Statement.RETURN_GENERATED_KEYS);
				
				prepare.setLong(1, usuarioRespondeFc.getFlashcardRespondido().getIdFlashcard());
				prepare.setLong(2, usuarioRespondeFc.getUsuarioResponde().getIdUsuario());
				
				
			
				
				prepare.executeUpdate();

				ResultSet rs = prepare.getGeneratedKeys();
				if (rs.next()) {
					long id = rs.getLong(1);
					usuarioRespondeFc.setIdUsuarioRespondeFc(id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// fechar a conexao com mysql
				this.conexao.fecharConexao();
			}
			return usuarioRespondeFc;
		}
	
public void excluir(long id) {
	this.conexao.abrirConexao();
	String sqlDelete = "DELETE FROM usuario_flashcard WHERE id_usuario_flashcard=?";
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
	
}}
	
	
	

