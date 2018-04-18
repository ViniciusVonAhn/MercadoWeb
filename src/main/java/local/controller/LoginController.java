package local.controller;

import java.util.List;

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
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Integer id) {
		LoginDAO.deleteById(id);
		
	}
	
	@PutMapping("/alterar")
	public void alterar(String usuario, String senha, Integer id) {
		Login user = new Login();
		user.setId(id);
		user.setUsuario(usuario);
		user.setSenha(senha);
	    LoginDAO.save(user);
		
	}
}
