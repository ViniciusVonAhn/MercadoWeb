package local.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.repository.UsuarioRepository;
import local.model.Usuario;

@RestController
@RequestMapping("admin/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository UsuarioDAO;
	
	@PostMapping
	public Usuario cadastrar(@RequestBody Usuario usuario) {	
		return UsuarioDAO.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> listar(){
		return UsuarioDAO.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> listarUm(@PathVariable Integer id) {
		return UsuarioDAO.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Integer id) {
		UsuarioDAO.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public Usuario alterar(@RequestBody Usuario usuario) {
		return UsuarioDAO.save(usuario);
		
	}
	
	@GetMapping("/busca/{nome}")
	public List<Usuario> busca(@PathVariable("nome")String nome) {
		return UsuarioDAO.findByNome(nome);
	}
}
