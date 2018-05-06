package local.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	List<Produto> findByNomeIgnoreCase(String nome);
	
}
