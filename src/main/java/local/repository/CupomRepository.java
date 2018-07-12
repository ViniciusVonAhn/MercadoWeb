package local.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import local.model.Cupom;

@Repository
@Transactional()
public interface CupomRepository extends JpaRepository<Cupom, Integer>{

	@Modifying
    @Transactional
    @Query("delete from Cupom where cupom_id = :cupom_id and produto_id = :produto_id")
    void deleteUsingSingleQuery(@Param("cupom_id")int cupom_id,
    							@Param("produto_id")int produto_id);
	
	List<Cupom> findByCupomIdCupomId(Integer id);
	
	/**@Query(
			value = "SELECT p.id, p.nome, c.quant_vendida, c.valor_produto FROM cupom c INNER JOIN produto p ON c.cupom_id = :cupom_id INNER JOIN cupom ON c.produto_id = p.id GROUP BY p.id",
			nativeQuery = true)
    List<Cupom> CupomById(@Param("cupom_id")int cupom_id);
    **/
}
