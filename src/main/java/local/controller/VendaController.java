package local.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Cupom;
import local.model.Venda;
import local.repository.VendaRepository;

@RestController
@RequestMapping("/venda")
@CrossOrigin("http://localhost:8081")
public class VendaController {

	@Autowired VendaRepository VendaDAO;
	
	
	@PostMapping
	public void vender(Venda venda) {
		VendaDAO.save(venda);
	}
	
	@GetMapping
	public List<Venda> listar(){
		return VendaDAO.findAll();
	}
	
}
