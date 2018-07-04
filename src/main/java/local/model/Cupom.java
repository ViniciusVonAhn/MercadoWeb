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
	private CupomId cupomId;
	
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

	public Cupom() {
		super();
	}

	public Cupom(CupomId cupomId, int quantVendida, double valorProduto, Produto produto, List<Venda> venda) {
		super();
		this.cupomId = cupomId;
		this.quantVendida = quantVendida;
		this.valorProduto = valorProduto;
		this.produto = produto;
		this.venda = venda;
	}

	public CupomId getCupomId() {
		return cupomId;
	}

	public void setCupomId(CupomId cupomId) {
		this.cupomId = cupomId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cupomId == null) ? 0 : cupomId.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + quantVendida;
		long temp;
		temp = Double.doubleToLongBits(valorProduto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupom other = (Cupom) obj;
		if (cupomId == null) {
			if (other.cupomId != null)
				return false;
		} else if (!cupomId.equals(other.cupomId))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantVendida != other.quantVendida)
			return false;
		if (Double.doubleToLongBits(valorProduto) != Double.doubleToLongBits(other.valorProduto))
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cupom [cupomId=" + cupomId + ", quantVendida=" + quantVendida + ", valorProduto=" + valorProduto
				+ ", produto=" + produto + ", venda=" + venda + "]";
	}
	
}
