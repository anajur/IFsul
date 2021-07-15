package com.integrador.apresentacao;

import java.sql.Date;
import java.util.List;

import com.integrador.model.Flashcard;
import com.integrador.model.GrupoEstudo;
import com.integrador.model.Pasta;
import com.integrador.model.PastaPublicacao;
import com.integrador.model.Publicacao;
import com.integrador.model.Usuario;
import com.integrador.model.UsuarioSegueUsuario;
import com.integrador.persistence.FlashcardDAO;
import com.integrador.persistence.GrupoEstudoDAO;
import com.integrador.persistence.PastaDAO;
import com.integrador.persistence.PastaPublicacaoDAO;
import com.integrador.persistence.PublicacaoDAO;
import com.integrador.persistence.UsuarioDAO;
import com.integrador.persistence.UsuarioSegueUsuarioDAO;

public class Main {

	public static void main(String[] args) {
		
		
		// TESTES DAO //
		
	UsuarioDAO u = new UsuarioDAO();
	u.logar("ana", "a");
		
	GrupoEstudo g= new GrupoEstudo(0,"grupo","mat", null);
	GrupoEstudoDAO gg=new GrupoEstudoDAO();
	gg.adicionar(g);
		
	Usuario u1 = new Usuario(0, "zulema", "zu", "z", "zari", "z", "z", null, null, null, null, null, null);


	Pasta p1= new Pasta(0, "geografia", "geografia", u1, null);

		
	UsuarioDAO uu1= new UsuarioDAO();
	uu1.salvar(u1);
	
	PastaDAO pp1= new PastaDAO();
	pp1.adicionar(p1);

		

//   pp1.excluir(7);

	
	}}

