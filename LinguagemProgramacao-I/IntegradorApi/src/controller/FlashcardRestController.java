package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.model.Flashcard;
import com.integrador.model.Pasta;
import com.integrador.model.Publicacao;
import com.integrador.model.Usuario;
import com.integrador.persistence.FlashcardDAO;
import com.integrador.persistence.PublicacaoDAO;


@RestController
	@RequestMapping("/flashcard")
public class FlashcardRestController {


	

		private FlashcardDAO flashcardDAO = new FlashcardDAO();

		@GetMapping
		public ResponseEntity<List<Flashcard>> listarFlashcard() {
			return ResponseEntity.ok(flashcardDAO.buscarTodos());
		}
		@GetMapping("/flashcard/{id}")
		public ResponseEntity<List<Flashcard>> listarFlashcardPorId(@PathVariable long id) {
		return ResponseEntity.ok(flashcardDAO.buscarFlashcardPorIdUsuario(id));
	}
		
		

		

		@PostMapping
		public ResponseEntity<Flashcard> adicionar(@RequestBody Flashcard flashcard) {
			return ResponseEntity.ok((flashcardDAO.adicionar(flashcard)));
		}

		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable long id) {
			flashcardDAO.excluir(id);
			return ResponseEntity.noContent().build();
		}
		
			
		
		@PutMapping
		public ResponseEntity<Flashcard> atualizar(@RequestBody Flashcard u) {
		flashcardDAO.editar(u);
		return ResponseEntity.noContent().build();
		}
		@GetMapping("{id}")
		public Flashcard getFlashcard(@PathVariable(name = "id") long id) {
		return flashcardDAO.buscarPorId(id);
		}
}

	
