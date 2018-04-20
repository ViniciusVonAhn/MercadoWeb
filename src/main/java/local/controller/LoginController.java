package local.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.repository.LoginRepository;
import local.model.Login;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginRepository LoginDAO;
	
	@PostMapping("/cadastro")
	public void cadastrar(String usuario, String senha) {
		Login user = new Login();
		user.setUsuario(usuario);
		user.setSenha(senha);
		LoginDAO.save(user);
	}
	
	@GetMapping("/lista")
	public List<Login> listar(){
		return LoginDAO.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Login> listarUm(@PathVariable Integer id) {
		return LoginDAO.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Integer id) {
		LoginDAO.deleteById(id);
		
	}
	
	@PutMapping("/alterar")
	public Login alterar(@RequestBody Login login) {
		return LoginDAO.save(login);
		
	}
	
	@GetMapping("/busca/{usuario}")
	public List<Login> busca(@PathVariable("usuario")String usuario) {
		return LoginDAO.findByUsuarioIgnoreCase(usuario);
	}
}
