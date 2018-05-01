package local.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cupom{

	@EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "cupom_id", column = @Column(name = "cupom_id", nullable = false)),
            @AttributeOverride(name = "produto_id", column = @Column(name = "produto_id", nullable = false)) })
	private CupomID id;
	
	@NotBlank(message = "A Data deve ser informado!")
	@NotNull(message = "A Data não pode ficar em branco!")
	//@Column(name = "nome", length = 50, nullable = false)
	@Column(nullable=false)
	private Date data;
	
	@NotBlank(message = "A Hora deve ser informado!")
	@NotNull(message = "A Hora não pode ficar em branco!")
	@Column(nullable=false)
	private Time hora;
	
	@NotBlank(message = "O Nome do produto deve ser informado!")
	@NotNull(message = "O Nome do produto não pode ficar em branco!")
	@Column(name="nome_produto", length = 50, nullable=true)
	private String nomeProduto;
	
	
	@Column(length = 14)
	private String cpf;
	
	@NotBlank(message = "A Quantidade Vendida deve ser informado!")
	@NotNull(message = "A Quantidade Vendida não pode ficar em branco!")
	@Column(name="quant_vendida", nullable=false, columnDefinition="Decimal(9,2)")
	private double quantVendida;
	
	@NotBlank(message = "O Valor Unitário deve ser informado!")
	@NotNull(message = "O Valor Unitário não pode ficar em branco!")
	@Column(name="valor_unitario", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorUnitario;
	
	@NotBlank(message = "O Valor do Produto deve ser informado!")
	@NotNull(message = "O Valor do Produto não pode ficar em branco!")
	@Column(name="valor_produto", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorProduto;
	
	@NotBlank(message = "O Valor Recebido deve ser informado!")
	@NotNull(message = "O Valor Recebido não pode ficar em branco!")
	@Column(name="valor_recebido", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorRecebido;
	
	@NotBlank(message = "O Valor do Troco deve ser informado!")
	@NotNull(message = "O Valor do Troco não pode ficar em branco!")
	@Column(name="valor_troco", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTroco;
	
	@ManyToOne
    @JoinColumn(name = "produto_id", nullable = false, insertable = false, updatable = false)
	private Produto produto;
	
	@OneToOne
	@JoinColumn(name="empresa_id", nullable=false)
	private Empresa empresa;
	
	@JsonIgnore
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(quantVendida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorProduto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorRecebido);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTroco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorUnitario);
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (Double.doubleToLongBits(quantVendida) != Double.doubleToLongBits(other.quantVendida))
			return false;
		if (Double.doubleToLongBits(valorProduto) != Double.doubleToLongBits(other.valorProduto))
			return false;
		if (Double.doubleToLongBits(valorRecebido) != Double.doubleToLongBits(other.valorRecebido))
			return false;
		if (Double.doubleToLongBits(valorTroco) != Double.doubleToLongBits(other.valorTroco))
			return false;
		if (Double.doubleToLongBits(valorUnitario) != Double.doubleToLongBits(other.valorUnitario))
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
		return "Cupom [id=" + id + ", data=" + data + ", hora=" + hora + ", nomeProduto=" + nomeProduto + ", cpf=" + cpf
				+ ", quantVendida=" + quantVendida + ", valorUnitario=" + valorUnitario + ", valorProduto="
				+ valorProduto + ", valorRecebido=" + valorRecebido + ", valorTroco=" + valorTroco + ", produto="
				+ produto + ", empresa=" + empresa + "]";
	}
	
}
