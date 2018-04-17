package local.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.repository.LoginRepository;
import local.model.Login;

@RestController
@RequestMapping("/usuario")
public class LoginController {

	@Autowired
	private LoginRepository UsuarioDAO;
	
	@PostMapping("/cadastro")
	public void Cadastrar(String usuario, String senha) {
		Login user = new Login();
		user.setUsuario(usuario);
		user.setSenha(senha);
		UsuarioDAO.save(user);
	}
	
	@GetMapping("/lista")
	public List<Login> listar(){
		return UsuarioDAO.findAll();
	}
	
}
