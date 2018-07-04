package local.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(name="codigo_de_barra")
	private String codigoDeBarra;
	
	@Column(nullable=false)
	private int estoque;
	
	@Column(name="valor_un", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorUn;

	@JsonIgnore
	@OneToMany(mappedBy = "produto")
	private List<Cupom> cupom;

	public Produto() {
		super();
	}
	
	public Produto(int id, String nome, String codigoDeBarra, int estoque, double valorUn, List<Cupom> cupom) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoDeBarra = codigoDeBarra;
		this.estoque = estoque;
		this.valorUn = valorUn;
		this.cupom = cupom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valorUn) != Double.doubleToLongBits(other.valorUn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", codigoDeBarra=" + codigoDeBarra + ", estoque=" + estoque
				+ ", valorUn=" + valorUn + ", cupom=" + cupom + "]";
	}

}
