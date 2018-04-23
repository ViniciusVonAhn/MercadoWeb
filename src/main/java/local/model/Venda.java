package local.model;

import javax.persistence.*;

@Entity
public class Venda extends GenericModel{

	@Column(name="produto_venda", nullable=false)
	private String produtoVenda;
	@Column(name="quant_venda", nullable=false)
	private int quantVenda;
	@Column(name="valor_unitario_venda", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorUnitarioVenda;
	@Column(name="valor_total_venda", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTotalVenda;
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name="cupom_id")
	private Cupom cupom;
	
	public String getProdutoVenda() {
		return produtoVenda;
	}
	public void setProdutoVenda(String produtoVenda) {
		this.produtoVenda = produtoVenda;
	}
	public int getQuantVenda() {
		return quantVenda;
	}
	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}
	public double getValorUnitarioVenda() {
		return valorUnitarioVenda;
	}
	public void setValorUnitarioVenda(double valorUnitarioVenda) {
		this.valorUnitarioVenda = valorUnitarioVenda;
	}
	public double getValorTotalVenda() {
		return valorTotalVenda;
	}
	public void setValorTotalVenda(double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cupom getCupom() {
		return cupom;
	}
	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cupom == null) ? 0 : cupom.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((produtoVenda == null) ? 0 : produtoVenda.hashCode());
		result = prime * result + quantVenda;
		long temp;
		temp = Double.doubleToLongBits(valorTotalVenda);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorUnitarioVenda);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (cupom == null) {
			if (other.cupom != null)
				return false;
		} else if (!cupom.equals(other.cupom))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (produtoVenda == null) {
			if (other.produtoVenda != null)
				return false;
		} else if (!produtoVenda.equals(other.produtoVenda))
			return false;
		if (quantVenda != other.quantVenda)
			return false;
		if (Double.doubleToLongBits(valorTotalVenda) != Double.doubleToLongBits(other.valorTotalVenda))
			return false;
		if (Double.doubleToLongBits(valorUnitarioVenda) != Double.doubleToLongBits(other.valorUnitarioVenda))
			return false;
		return true;
	}
	
	
	
	
	
}
