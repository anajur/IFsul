package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.integrador.model.GrupoEstudo;
import com.integrador.persistence.GrupoEstudoDAO;
@RestController
	@RequestMapping("/grupo")
public class GrupoEstudoRestController {

	



		private GrupoEstudoDAO grupoEstudoDAO = new GrupoEstudoDAO();

		@GetMapping
		public ResponseEntity<List<GrupoEstudo>> listarGrupos() {
			return ResponseEntity.ok(grupoEstudoDAO.buscarTodos());
		}

		@PostMapping
		public ResponseEntity<GrupoEstudo> adicionar(@RequestBody GrupoEstudo grupoEstudo) {
			return ResponseEntity.ok((grupoEstudoDAO.adicionar(grupoEstudo)));
		}

		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable long id) {
			grupoEstudoDAO.excluir(id);
			return ResponseEntity.noContent().build();
		}

		//
		@PutMapping
		public ResponseEntity<GrupoEstudo> editar(@RequestBody GrupoEstudo grupoEstudo) {
			grupoEstudoDAO.editar(grupoEstudo);
			return ResponseEntity.noContent().build();}
	
			@GetMapping("{id}")
			public GrupoEstudo getEstudo(@PathVariable(name = "id") long id) {
			return grupoEstudoDAO.buscarPorId(id);
		

	}}
