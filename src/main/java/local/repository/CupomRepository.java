package local.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import local.model.Cupom;
import local.model.CupomId;

@Repository
@Transactional()
public interface CupomRepository extends JpaRepository<Cupom, Integer>{

	@Modifying
    @Transactional
    @Query("delete from Cupom where cupom_id = :cupom_id and produto_id = :produto_id")
    void deleteUsingSingleQuery(@Param("cupom_id")int cupom_id,
    							@Param("produto_id")int produto_id);
	
	List<Cupom> findByCupomIdCupomId(Integer id);
	
}
