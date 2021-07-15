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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.model.Flashcard;
import com.integrador.model.Pasta;
import com.integrador.model.Publicacao;
import com.integrador.persistence.PublicacaoDAO;


@RestController
	@RequestMapping("/publicacao")
public class PublicacaoRestController {

	




	

		private PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
		
		
		
		@GetMapping
		public ResponseEntity<List<Publicacao>> listarPublicacoes() {
			return ResponseEntity.ok(publicacaoDAO.buscarTodos());
		}

		@PostMapping
		public ResponseEntity<Publicacao> adicionar(@RequestBody Publicacao publicacao) {
			return ResponseEntity.ok((publicacaoDAO.adicionar(publicacao)));
		}

		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable long id) {
			publicacaoDAO.excluir(id);
			return ResponseEntity.noContent().build();
		}
		@PutMapping
		public ResponseEntity<Publicacao> atualizar(@RequestBody Publicacao u) {
		publicacaoDAO.editar(u);
		return ResponseEntity.noContent().build();
		}
		@GetMapping("{id}")
		public Publicacao getPublicacao(@PathVariable(name = "id") long id) {
		return publicacaoDAO.buscarPorId(id);
		}

@GetMapping("/categoria/{categoria}")
	 public List<Publicacao> getPublicacao(@PathVariable(name = "categoria") String categoria) {
	 return publicacaoDAO.buscarPorCategoria(categoria);
	 }}
	






