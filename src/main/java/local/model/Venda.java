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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((cupom == null) ? 0 : cupom.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorRecebido);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTroco);
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (cupom == null) {
			if (other.cupom != null)
				return false;
		} else if (!cupom.equals(other.cupom))
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
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (Double.doubleToLongBits(valorRecebido) != Double.doubleToLongBits(other.valorRecebido))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		if (Double.doubleToLongBits(valorTroco) != Double.doubleToLongBits(other.valorTroco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [data=" + data + ", time=" + time + ", valorTotal=" + valorTotal + ", valorRecebido="
				+ valorRecebido + ", valorTroco=" + valorTroco + ", cpf=" + cpf + ", cupom=" + cupom + ", empresa="
				+ empresa + "]";
	}

	
}
