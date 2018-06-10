package local.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Venda extends GenericModel{

	@Column
	private Date data;
	
	@Column
	private Time time;
	
	@Column(name="valor_total", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTotal;
	
	@Column(name="valor_recebido", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorRecebido;
	
	@Column(name="valor_troco", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTroco;
	
	@Column
	private String cpf;
	
	@ManyToOne(optional = false)
	@JoinColumns({
		  @JoinColumn(name = "cupom_id", insertable = false, updatable = false),
		  @JoinColumn(name = "produto_id", insertable = false, updatable = false)
		})
	@JsonIgnore
	private Cupom cupom;

	@OneToOne
	@JsonIgnore
	@JoinColumn(name="empresa_id")
	private Empresa empresa;

	public Venda() {
		super();
	}

	public Venda(Date data, Time time, double valorTotal, double valorRecebido, double valorTroco, String cpf) {
		super();
		this.data = data;
		this.time = time;
		this.valorTotal = valorTotal;
		this.valorRecebido = valorRecebido;
		this.valorTroco = valorTroco;
		this.cpf = cpf;
	}

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
