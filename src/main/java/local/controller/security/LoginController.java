package local.controller.security;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import local.model.Usuario;
import local.repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")

public class LoginController {
	
	@Autowired
	private UsuarioRepository UsuarioDAO;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody Usuario usuario) {
		
		if(usuario.getNome() == null || usuario.getSenha() == null) {
			System.out.println("primeiro if do logincontroller");
			return new ResponseEntity<>("Usuario ou senha não encontrados", HttpStatus.UNAUTHORIZED);
		}
		
		Usuario user = UsuarioDAO.findByNome(usuario.getNome()).get(0);
		
		if (!user.getSenha().equals(usuario.getSenha())) {
			System.out.println("senha invalida");
			return new ResponseEntity<>("senha inválida", HttpStatus.UNAUTHORIZED);
		}
		
		 String token = Jwts.builder()
	                .setSubject(usuario.getNome())
	                .signWith(SignatureAlgorithm.HS512, "mercadoweb")
	                .setExpiration(new Date(System.currentTimeMillis() + (30 * 60 * 1000)))
	                .compact();
		 
		 return new ResponseEntity<>(new TokenResponse (token, user.getRole(), user.getNome()), HttpStatus.OK);
	}
	
	private class TokenResponse {

        public String token;

        public String role;

        public String nome;

        public TokenResponse(String token, String role, String nome) {
            this.token = token;
            this.role = role;
            this.nome = nome;
        }
}
}
