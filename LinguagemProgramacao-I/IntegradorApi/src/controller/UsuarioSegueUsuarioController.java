package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.model.Usuario;
import com.integrador.model.UsuarioSegueUsuario;
import com.integrador.persistence.UsuarioDAO;
import com.integrador.persistence.UsuarioSegueUsuarioDAO;
@RestController
@RequestMapping("/usuariosegue")
public class UsuarioSegueUsuarioController {
	private UsuarioSegueUsuarioDAO usuarioDAO = new UsuarioSegueUsuarioDAO();

	
	@GetMapping("{id}")
	public ResponseEntity<UsuarioSegueUsuario>listarUsuarioPorId(@PathVariable long id) {
	return ResponseEntity.ok(usuarioDAO.ContarSeguidores(id));
}

}
