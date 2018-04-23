package local.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.model.Cupom;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Integer>{

}
