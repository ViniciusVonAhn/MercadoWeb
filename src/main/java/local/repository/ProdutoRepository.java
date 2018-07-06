package local.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import local.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	List<Produto> findByNomeIgnoreCase(String nome);
	
	List<Produto> findBycodigoDeBarraIgnoreCase(String codigoDeBarra);
	
	@Modifying
    @Transactional
	@Query("SELECT p FROM Produto p where estoque <= :estoque")
    List<Produto> estoqueFind(@Param("estoque")int estoque);
}
