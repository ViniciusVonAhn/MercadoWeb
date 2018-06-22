package local.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Cupom;
import local.model.Produto;
import local.repository.CupomRepository;
import local.repository.ProdutoRepository;

@RestController
@RequestMapping("/cupom")
@CrossOrigin("*")
public class CupomController {

	@Autowired
	private CupomRepository CupomDAO;
	
	@Autowired
	private ProdutoRepository ProdutoDAO;
	
	@PostMapping
	public Cupom cadCupom(@RequestBody Cupom cupom) {
		 int quantCupom = cupom.getQuantVendida();
		 System.out.println(quantCupom);
		 System.out.println(cupom.getProduto().getEstoque());
		 System.out.println(cupom.getProduto().getEstoque() - quantCupom);
		 int estoque = cupom.getProduto().getEstoque() - quantCupom;
		 cupom.getProduto().setEstoque(estoque);
		 return CupomDAO.save(cupom);
		 
	}
	
	@GetMapping
	public List<Cupom> listar(){
		return CupomDAO.findAll();
	}
	
	@GetMapping("/{id}")
	/*
	 * Não está funcionando, verificar a existencia das classes Cupom e CupomID.
	 */
	public Optional<Cupom> listaUm(@PathVariable Integer id){
		return CupomDAO.findById(id);
	}
	
	@DeleteMapping("/{cupom_id}/{produto_id}")
	public void remover(@PathVariable Integer cupom_id,
						@PathVariable Integer produto_id ) {
		//CupomDAO.deleteById(cupom_id, produto_id);
		CupomDAO.deleteUsingSingleQuery(cupom_id, produto_id);
	}
	
}
