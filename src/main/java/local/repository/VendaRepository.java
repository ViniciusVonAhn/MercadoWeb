package local.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import local.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

	@Modifying
    @Transactional
	@Query("SELECT v FROM Venda v where id = :id")
    List<Venda> idFind(@Param("id")Integer id);
}
