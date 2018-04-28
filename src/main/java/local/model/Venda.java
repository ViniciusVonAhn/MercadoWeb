package local.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Venda extends GenericModel{

	@Column(nullable=false)
	private Date data;
	
	@Column(nullable=false)
	private Time time;
	
	@Column(name="valor_total", nullable=false, columnDefinition="Decimal(9,2)")
	private double valorTotal;
	
	@ManyToOne
	@JoinColumns({
		  @JoinColumn(name = "cupom_id", insertable = false, updatable = false),
		  @JoinColumn(name = "produto_id", insertable = false, updatable = false)
		})
	private Cupom cupom;

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

	
	
	
}
