package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Aluno;

public class Menu {
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

	public void adicionar(Aluno aluno) {
		alunos.add(aluno);
	}

	public void buscarAluno(String nome) {

		List<Aluno> alunosEncontrados = alunos.stream().filter(a -> a.getNome().equals(nome))
				.collect(Collectors.toList());
		if (alunosEncontrados.isEmpty()) {
			System.out.println("Nenhum aluno encontrado.");
		} else {
			alunosEncontrados.forEach(a -> System.out.println(a));
		}
	}

	public void remover() {
		if (alunos.isEmpty()) {
			System.out.println("A lista está vazia.");
		} else {
			int posicao = alunos.size()-1;
			alunos.remove(posicao);
			System.out.println("Aluno removido!");

		}
	}

	public void imprimir() {
		alunos.forEach(a -> System.out.println(a));

	}
}
