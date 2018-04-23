package local.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cupom extends GenericModel{

	@Column(nullable=false)
	private Date data;
	@Column(nullable=false)
	private Time time;
	@Column(nullable=true)
	private String cpf;
	@Column(name="valor_total_cupom", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTotalCupom;
	@Column(name="valor_recebido", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorRecebido;
	@Column(name="valor_troco", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTroco;
	@Column(name="venda_cupom", nullable=false)
	@OneToMany(mappedBy = "cupom")
	private List<Venda> vendaListCupom;
	@ManyToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getValorTotalCupom() {
		return valorTotalCupom;
	}
	public void setValorTotalCupom(double valorTotalCupom) {
		this.valorTotalCupom = valorTotalCupom;
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
	public List<Venda> getVendaListCupom() {
		return vendaListCupom;
	}
	public void setVendaListCupom(List<Venda> vendaListCupom) {
		this.vendaListCupom = vendaListCupom;
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
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorRecebido);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTotalCupom);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTroco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vendaListCupom == null) ? 0 : vendaListCupom.hashCode());
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
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (Double.doubleToLongBits(valorRecebido) != Double.doubleToLongBits(other.valorRecebido))
			return false;
		if (Double.doubleToLongBits(valorTotalCupom) != Double.doubleToLongBits(other.valorTotalCupom))
			return false;
		if (Double.doubleToLongBits(valorTroco) != Double.doubleToLongBits(other.valorTroco))
			return false;
		if (vendaListCupom == null) {
			if (other.vendaListCupom != null)
				return false;
		} else if (!vendaListCupom.equals(other.vendaListCupom))
			return false;
		return true;
	}
	
	
}
