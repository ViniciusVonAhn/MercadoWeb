package local.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Cupom;
import local.model.Produto;
import local.model.Venda;
import local.repository.CupomRepository;
import local.repository.VendaRepository;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("admin/venda")
@CrossOrigin("*")
public class VendaController {

	@Autowired 
	VendaRepository VendaDAO;
	
	@Autowired 
	CupomRepository CupomDAO;
	
	
	@PostMapping
	public Venda vender(@RequestBody Venda venda) {
		return VendaDAO.save(venda);
	}
	
	@GetMapping
	public List<Venda> listar(){
		return VendaDAO.findAll();
	}
	
	@GetMapping("cupom/{id}")
	public List<Cupom> listaUm(@PathVariable Integer id){
		return CupomDAO.findByCupomIdCupomId(id);
	}
	
	@GetMapping("/{id}")
	public List<Venda> listaVenda(@PathVariable Integer id){
		return VendaDAO.idFind(id);
	}
	
}
