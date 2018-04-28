package local.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.*;


@Entity
public class Cupom{

	@EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "cupom_id", column = @Column(name = "cupom_id", nullable = false)),
            @AttributeOverride(name = "produto_id", column = @Column(name = "produto_id", nullable = false)) })
	private CupomID id;
	
	@Column(nullable=false)
	private Date data;
	
	@Column(nullable=false)
	private Time hora;
	
	@Column(name="nome_produto", nullable=true)
	private String nomeProduto;
	
	@Column(nullable=true)
	private String cpf;
	
	@Column(name="quant_vendida", nullable=false, columnDefinition="Decimal(9,2)")
	private double quantVendida;
	
	@Column(name="valor_unitario", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorUnitario;
	
	@Column(name="valor_produto", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorProduto;
	
	@Column(name="valor_recebido", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorRecebido;
	
	@Column(name="valor_troco", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTroco;
	
	@ManyToOne
    @JoinColumn(name = "produto_id", nullable = false, insertable = false, updatable = false)
	private Produto produto;
	
	@OneToOne
	@JoinColumn(name="empresa_id", nullable=false)
	private Empresa empresa;
	
	@OneToMany(mappedBy = "cupom")
	private List<Venda> venda;

	public CupomID getId() {
		return id;
	}

	public void setId(CupomID id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getQuantVendida() {
		return quantVendida;
	}

	public void setQuantVendida(double quantVendida) {
		this.quantVendida = quantVendida;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Venda> getVenda() {
		return venda;
	}

	public void setVenda(List<Venda> venda) {
		this.venda = venda;
	}
	
	
	
}
