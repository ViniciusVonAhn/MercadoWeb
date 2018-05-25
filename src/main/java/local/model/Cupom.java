package local.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cupom{

	@EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "cupom_id", column = @Column(name = "cupom_id", nullable = false)),
            @AttributeOverride(name = "produto_id", column = @Column(name = "produto_id", nullable = false)) })
	private CupomID id;
	
	@Column(name="quant_vendida", nullable=false)
	private int quantVendida;
	
	@Column(name="valor_produto", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorProduto;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id", nullable = false, insertable = false, updatable = false)
	private Produto produto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cupom")
	private List<Venda> venda;

	public CupomID getId() {
		return id;
	}

	public void setId(CupomID id) {
		this.id = id;
	}

	public int getQuantVendida() {
		return quantVendida;
	}

	public void setQuantVendida(int quantVendida) {
		this.quantVendida = quantVendida;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Venda> getVenda() {
		return venda;
	}

	public void setVenda(List<Venda> venda) {
		this.venda = venda;
	}

	
}
