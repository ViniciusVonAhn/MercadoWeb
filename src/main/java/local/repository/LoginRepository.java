package local.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

}
