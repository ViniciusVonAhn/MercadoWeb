package local.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Cupom;
import local.model.Produto;
import local.repository.CupomRepository;

@RestController
@RequestMapping("/cupom")
@CrossOrigin("http://localhost:8081")
public class CupomController {

	@Autowired
	private CupomRepository CupomDAO;
	
	@PostMapping
	public Cupom cadCupom(@RequestBody Cupom cupom) {
		Cupom cup = new Cupom();
		Produto prod = new Produto(); 
		/*
		 * Arrumar a quantVendida, alterar para int ao invés de double.
		 * pega a quantidade vendida e armazena no quantCupom para diminuir no estoque
		 * int quantCupom = cup.getQuantVendida();
		 * 
		 * prod.setEstoque(prod.getEstoque() - quantCupom);
		 */
		return CupomDAO.save(cupom);
		
	}
	
	@GetMapping
	public List<Cupom> listar(){
		return CupomDAO.findAll();
	}
}
