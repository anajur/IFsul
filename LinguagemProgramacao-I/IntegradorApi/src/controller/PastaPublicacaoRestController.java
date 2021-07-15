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

import com.integrador.model.Pasta;
import com.integrador.model.PastaPublicacao;
import com.integrador.persistence.PastaPublicacaoDAO;
@RestController
	@RequestMapping("/pastapub")
public class PastaPublicacaoRestController {










	



		private PastaPublicacaoDAO pastaPublicacaoDAO = new PastaPublicacaoDAO();

		@GetMapping
		public ResponseEntity<List<PastaPublicacao>> listarGrupos() {
			return ResponseEntity.ok(pastaPublicacaoDAO.buscarTodos());
		}
//
		@PostMapping
		public ResponseEntity<PastaPublicacao> adicionar(@RequestBody PastaPublicacao pastaPublicacao) {
			return ResponseEntity.ok((pastaPublicacaoDAO.salvar(pastaPublicacao)));
		}
		@GetMapping("/pasta/{id}")
		public ResponseEntity<List<PastaPublicacao>> listarPastasPorId(@PathVariable long id) {
		return ResponseEntity.ok(pastaPublicacaoDAO.listarPublicacaoPasta(id));}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable long id) {
			pastaPublicacaoDAO.equals(id);
			return ResponseEntity.noContent().build();
		}
		
		
	}