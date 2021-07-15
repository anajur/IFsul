package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.model.Pasta;
import com.integrador.model.UsuarioParticipaGE;
import com.integrador.persistence.PublicacaoDAO;
import com.integrador.persistence.UsuarioParticipaGEDAO;

@RestController
@RequestMapping("/participantes")

public class UsuarioParticipaGEController {

	private UsuarioParticipaGEDAO usuarioParticipaGEDAO = new UsuarioParticipaGEDAO();


	@PostMapping
	public ResponseEntity<UsuarioParticipaGE> adicionar(@RequestBody UsuarioParticipaGE usuarioParticipaGE) {
		return ResponseEntity.ok((usuarioParticipaGE));
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable long id) {
		usuarioParticipaGEDAO.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
