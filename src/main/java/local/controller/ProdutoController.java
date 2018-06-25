package local.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import local.model.Produto;
import local.repository.ProdutoRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired ProdutoRepository ProdutoDAO;
	
	@GetMapping("/PDF")
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<byte[]> PDF(HttpServletResponse response) throws JRException {
		List<Produto> produtos = ProdutoDAO.findAll();
		Map<String, Object> parametros = new HashMap<>();
		InputStream inputStream = getClass().getResourceAsStream("/reports/Produtos.jrxml");
		JasperReport is = JasperCompileManager.compileReport(inputStream);
		JasperPrint print = JasperFillManager.fillReport(is, parametros, new JRBeanCollectionDataSource(produtos));
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE).body(JasperExportManager.exportReportToPdf(print));
	}
	
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public Produto cadastrar(@RequestBody Produto produto) {
		return ProdutoDAO.save(produto);
	}
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<Produto> listar(){
		return ProdutoDAO.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Optional<Produto> listarUm(@PathVariable Integer id) {
		return ProdutoDAO.findById(id);
	}
	
	@GetMapping("barra/{codigoDeBarra}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<Produto> listarCodBarra(@PathVariable String codigoDeBarra) {
		return ProdutoDAO.findBycodigoDeBarraIgnoreCase(codigoDeBarra);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void remover(@PathVariable Integer id) {
		ProdutoDAO.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ResponseEntity<Produto> alterar(@RequestBody Produto produto) {
		Produto prod = ProdutoDAO.save(produto);
		return new ResponseEntity<Produto>(prod, HttpStatus.OK);

	}
	
	@GetMapping("/nome/{nome}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<Produto> busca(@PathVariable("nome")String nome) {
		return ProdutoDAO.findByNomeIgnoreCase(nome);
	}
	
}
