package local.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;


@Entity
public class Venda extends GenericModel{

	@Column(nullable=false)
	private Date data;
	
	@Column(nullable=false)
	private Time time;
	
	@Column(name="valor_total", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTotal;
	
	@Column(name="valor_recebido", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorRecebido;
	
	@Column(name="valor_troco", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTroco;
	
	@Column(nullable=true)
	private String cpf;
	
	@ManyToOne
	@JoinColumns({
		  @JoinColumn(name = "cupom_id", insertable = false, updatable = false),
		  @JoinColumn(name = "produto_id", insertable = false, updatable = false)
		})
	private Cupom cupom;

	@OneToOne
	@JoinColumn(name="empresa_id", nullable=false)
	private Empresa empresa;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public double getValorTroco() {
		return valorTroco;
	}

	public void setValorTroco(double valorTroco) {
		this.valorTroco = valorTroco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
}
