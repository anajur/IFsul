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

import com.integrador.model.Flashcard;
import com.integrador.model.Pasta;
import com.integrador.model.Usuario;
import com.integrador.persistence.PastaDAO;
import com.integrador.persistence.UsuarioDAO;
@RestController
	@RequestMapping("/pasta")
public class PastaRestController {

	



	

		private PastaDAO pastaDAO = new PastaDAO();

		@GetMapping
		public ResponseEntity<List<Pasta>> listarPastas() {
			return ResponseEntity.ok(pastaDAO.buscarTodos());
		}
		@GetMapping("/usuario/{id}")
		public ResponseEntity<List<Pasta>> listarPastasPorId(@PathVariable long id) {
		return ResponseEntity.ok(pastaDAO.buscarPastasPorIdUsuario(id));
	}

		
		@PostMapping
		public ResponseEntity<Pasta> adicionar(@RequestBody Pasta pasta) {
			return ResponseEntity.ok((pastaDAO.adicionar(pasta)));
		}

		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable long id) {
			pastaDAO.excluir(id);
			return ResponseEntity.noContent().build();
		}

		//
	
		@PutMapping
		public ResponseEntity<Pasta> atualizar(@RequestBody Pasta u) {
		pastaDAO.editar(u);
		return ResponseEntity.noContent().build();
		}
	@GetMapping("{id}")
	public Pasta getPasta(@PathVariable(name = "id") long id) {
return pastaDAO.buscarPorId(id);
	}


}
