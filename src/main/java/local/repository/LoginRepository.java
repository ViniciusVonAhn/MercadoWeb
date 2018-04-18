package local.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	List<Login> findByUsuarioIgnoreCase(String usuario);

}
