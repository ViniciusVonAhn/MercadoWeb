package local.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import local.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

}
