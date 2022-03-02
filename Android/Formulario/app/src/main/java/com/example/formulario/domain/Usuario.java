package com.example.formulario.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private String nome;
    private String email;
    private String telefone;
    private String dataNascimento;
    private String genero;
    private ArrayList<String> interesses;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setInteresses(ArrayList<String> interesses) {
        this.interesses = interesses;
    }

    public ArrayList<String> getInteresses() {
        return interesses;
    }

    public Usuario(String nome, String email, String telefone, String dataNascimento, String genero, ArrayList<String> interesses) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.interesses = interesses;
    }

    public Usuario() {
    }
}
