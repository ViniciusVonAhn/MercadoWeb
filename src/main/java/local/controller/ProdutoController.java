package local.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Produto;
import local.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired ProdutoRepository ProdutoDAO;
	
	@PostMapping("/cadastro")
	public Produto cadastrar(Produto produto) {
		return ProdutoDAO.save(produto);
	}
	
	@GetMapping("/lista")
	public List<Produto> listar(){
		return ProdutoDAO.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> listarUm(@PathVariable Integer id) {
		return ProdutoDAO.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Integer id) {
		ProdutoDAO.deleteById(id);
	}
	
	@PutMapping("/alterar")
	public Produto alterar(@RequestBody Produto produto) {
		return ProdutoDAO.save(produto);
	}
	
	@GetMapping("/busca/{nome}")
	public List<Produto> busca(@PathVariable("nome")String nome) {
		return ProdutoDAO.findByNomeIgnoreCase(nome);
	}
	
}
