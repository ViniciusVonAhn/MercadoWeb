package local.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "produto_id", unique = true, nullable = false)
	private int produto_id;
	
	@NotBlank(message = "O Nome deve ser informado!")
	@NotNull(message = "O Nome não pode ficar em branco!")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name="codigo_de_barra", length = 13)
	private String codigoDeBarra;
	
	@NotBlank(message = "A quantidade em estoque deve ser informado!")
	@NotNull(message = "A quantidade em estoque não pode ficar em branco!")
	@Column(nullable=false)
	private int estoque;
	
	@NotBlank(message = "O valor Unitário deve ser informado!")
	@NotNull(message = "O valor Unitário não pode ficar em branco!")
	@Column(name="valor_un", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorUn;

	@JsonIgnore
	@OneToMany(mappedBy = "produto")
	private List<Cupom> cupom;

	public int getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}

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

	public int getEstoque() {
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

	public List<Cupom> getCupom() {
		return cupom;
	}

	public void setCupom(List<Cupom> cupom) {
		this.cupom = cupom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDeBarra == null) ? 0 : codigoDeBarra.hashCode());
		result = prime * result + ((cupom == null) ? 0 : cupom.hashCode());
		result = prime * result + estoque;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + produto_id;
		long temp;
		temp = Double.doubleToLongBits(valorUn);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Produto other = (Produto) obj;
		if (codigoDeBarra == null) {
			if (other.codigoDeBarra != null)
				return false;
		} else if (!codigoDeBarra.equals(other.codigoDeBarra))
			return false;
		if (cupom == null) {
			if (other.cupom != null)
				return false;
		} else if (!cupom.equals(other.cupom))
			return false;
		if (estoque != other.estoque)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (produto_id != other.produto_id)
			return false;
		if (Double.doubleToLongBits(valorUn) != Double.doubleToLongBits(other.valorUn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [produto_id=" + produto_id + ", nome=" + nome + ", codigoDeBarra=" + codigoDeBarra
				+ ", estoque=" + estoque + ", valorUn=" + valorUn + "]";
	}

}
