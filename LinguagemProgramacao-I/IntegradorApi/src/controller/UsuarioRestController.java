package controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.model.Pasta;
import com.integrador.model.Usuario;
import com.integrador.persistence.UsuarioDAO;

	@RestController
	@RequestMapping("/usuario")
public class UsuarioRestController {



	

		private UsuarioDAO usuarioDAO = new UsuarioDAO();

		@GetMapping
		public ResponseEntity<List<Usuario>> listarUsuarios() {
			return ResponseEntity.ok(usuarioDAO.buscarTodos());
		}
		@GetMapping("/id/{id}")
		public ResponseEntity<Usuario>listarUsuarioPorId(@PathVariable long id) {
		return ResponseEntity.ok(usuarioDAO.buscarPorId(id));
	}

		@PostMapping
		public ResponseEntity<Usuario> adicionar(@RequestBody Usuario usuario) {
			return ResponseEntity.ok((usuarioDAO.salvar(usuario)));
		}

		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable long id) {
			usuarioDAO.excluir(id);
			return ResponseEntity.noContent().build();
		}
		@RequestMapping (value="", method = RequestMethod.PUT)
		public ResponseEntity<Void> editarUsuario(@RequestBody Usuario usuario){
			usuarioDAO.editar(usuario);
			return (ResponseEntity<Void>) ResponseEntity.ok();
			
		}
		

	@GetMapping("/logar")
	public ResponseEntity<Usuario> logar(@RequestBody Usuario usuario) {
		    return ResponseEntity.ok(usuarioDAO.logar(usuario.getLogin(), usuario.getSenha()));
		}
		
		

}
