package local.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByNome(String nome);
	
	List<Usuario> findByNomeAndSenha(String nome, String senha);

}
