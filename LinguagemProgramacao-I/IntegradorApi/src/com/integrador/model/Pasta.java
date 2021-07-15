package com.integrador.model;

import java.util.ArrayList;

public class Pasta {
	private long idPasta;
	private String categoria;
	private String titulo;
	private Usuario usuarioPasta;
	

	
	private ArrayList<PastaPublicacao> publicacaoPertencePasta;

	
	
	public Pasta() {
		super();
	}
	
	
	
	
	



	public Pasta(long idPasta, String categoria, String titulo, Usuario usuarioPasta, ArrayList<PastaPublicacao> publicacaoPertencePasta) {
		super();
		this.idPasta = idPasta;
		this.categoria = categoria;
		this.titulo = titulo;
		this.usuarioPasta = usuarioPasta;
		
		this.publicacaoPertencePasta = publicacaoPertencePasta;
	}













	public long getIdPasta() {
		return idPasta;
	}
	public void setIdPasta(long idPasta) {
		this.idPasta = idPasta;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Usuario getUsuarioPasta() {
		return usuarioPasta;
	}
	public void setUsuarioPasta(Usuario usuarioPasta) {
		this.usuarioPasta = usuarioPasta;
	}








	public ArrayList<PastaPublicacao> getPublicacaoPertencePasta() {
		return publicacaoPertencePasta;
	}








	public void setPublicacaoPertencePasta(ArrayList<PastaPublicacao> publicacaoPertencePasta) {
		this.publicacaoPertencePasta = publicacaoPertencePasta;
	}








	@Override
	public String toString() {
		return "Pasta [idPasta=" + idPasta + ", categoria=" + categoria + ", titulo=" + titulo + ", usuarioPasta="
				+ usuarioPasta + ", publicacaoPertencePasta=" + publicacaoPertencePasta + "]";
	}
	
	


}
