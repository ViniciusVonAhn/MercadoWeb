package local.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Cupom;
import local.model.Venda;
import local.repository.VendaRepository;

@RestController
@RequestMapping("/venda")
@CrossOrigin("*")
public class VendaController {

	@Autowired VendaRepository VendaDAO;
	
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Venda vender(@RequestBody Venda venda) {
		return VendaDAO.save(venda);
	}
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<Venda> listar(){
		return VendaDAO.findAll();
	}
	
}
