package local.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Produto extends GenericModel{
	
	@Column(nullable=false)
	private String nome;
	@Column(name="codigo_de_barra")
	private String codigoDeBarra;
	@Column(nullable=false)
	private int estoque;
	@Column(name="valor_un", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorUn;
	@Column(name="venda_produto", nullable=false)
	@OneToMany(mappedBy = "produto")
	private List<Venda> vendaListProduto;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigoDeBarra() {
		return codigoDeBarra;
	}
	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}
	public double getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getValorUn() {
		return valorUn;
	}
	public void setValorUn(double valorUn) {
		this.valorUn = valorUn;
	}
	public List<Venda> getVendaListProduto() {
		return vendaListProduto;
	}
	public void setVendaListProduto(List<Venda> vendaListProduto) {
		this.vendaListProduto = vendaListProduto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoDeBarra == null) ? 0 : codigoDeBarra.hashCode());
		long temp;
		temp = Double.doubleToLongBits(estoque);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		temp = Double.doubleToLongBits(valorUn);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vendaListProduto == null) ? 0 : vendaListProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (codigoDeBarra == null) {
			if (other.codigoDeBarra != null)
				return false;
		} else if (!codigoDeBarra.equals(other.codigoDeBarra))
			return false;
		if (Double.doubleToLongBits(estoque) != Double.doubleToLongBits(other.estoque))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valorUn) != Double.doubleToLongBits(other.valorUn))
			return false;
		if (vendaListProduto == null) {
			if (other.vendaListProduto != null)
				return false;
		} else if (!vendaListProduto.equals(other.vendaListProduto))
			return false;
		return true;
	}
	
	
	
}
