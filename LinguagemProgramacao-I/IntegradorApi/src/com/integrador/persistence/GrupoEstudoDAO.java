package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.integrador.model.GrupoEstudo;
import com.integrador.model.Usuario;
import com.mysql.jdbc.Statement;

public class GrupoEstudoDAO {
	private ConexaoMysql conexao;

	public GrupoEstudoDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "bd_app", "root", "my3soul");
	}

	public GrupoEstudo adicionar(GrupoEstudo grupoEstudo) {
		// abrir conexao mysql
		this.conexao.abrirConexao();
		// criar a instrucao sql de insert
		String sqlInsert = "INSERT INTO grupo_estudo VALUES(null,?, ?)";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			prepare.setString(1, grupoEstudo.getNome_ge());
			prepare.setString(2, grupoEstudo.getCategoria());

			// executar essa instrucao
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				grupoEstudo.setIdGE(id);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("naodeu");
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}
		return grupoEstudo;
	}

	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM grupo_estudo WHERE id_ge=?";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);
			prepare.setLong(1, id);
			prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void editar(GrupoEstudo grupoEstudo) {
		// abrir conexao
		this.conexao.abrirConexao();
		// criar a instrucao sql
		String sqlUpdate = "UPDATE grupo_estudo SET nome_ge=?, categoria=? WHERE id_ge=?";
		// preparar a instrucao para ser executada
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			prepare.setString(1, grupoEstudo.getNome_ge());
			prepare.setString(2, grupoEstudo.getCategoria());
			prepare.setLong(3, grupoEstudo.getIdGE());

			// executar a instrucao
			prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar conexao
			this.conexao.fecharConexao();
		}
	}

	public List<GrupoEstudo> buscarTodos() {
		this.conexao.abrirConexao();
		List<GrupoEstudo> listaGrupoEstudo = new ArrayList<GrupoEstudo>();
		GrupoEstudo grupoEstudo = null;
		String sqlBuscarTodos = "SELECT * FROM grupo_estudo";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs = prepare.executeQuery();

			while (rs.next()) {
				grupoEstudo = new GrupoEstudo();
				grupoEstudo.setIdGE(rs.getLong("id_ge"));
				grupoEstudo.setNome_ge(rs.getString("nome_ge"));
				grupoEstudo.setCategoria(rs.getString("categoria"));

				// FALTOU OBJECT USUARIO ADICIONA

				listaGrupoEstudo.add(grupoEstudo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaGrupoEstudo;
	}

	public GrupoEstudo buscarPorId(long id) {
		this.conexao.abrirConexao();
		GrupoEstudo grupoEstudo = null;
		String sqlBuscarPorId = "SELECT * FROM grupo_estudo WHERE id_ge=?";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			prepare.setLong(1, id);

			ResultSet rs = prepare.executeQuery();

			if (rs.next()) {
				// EXISTE A LINHA E TEMOS QUE CONVERTER A LINHA PARA UM OBJETO USUARIO
				grupoEstudo = new GrupoEstudo();
				grupoEstudo.setIdGE(rs.getLong("id_ge"));
				grupoEstudo.setNome_ge(rs.getString("nome_ge"));
				grupoEstudo.setCategoria(rs.getString("categoria"));
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grupoEstudo;

	}

}
