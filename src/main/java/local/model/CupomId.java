package local.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CupomId implements java.io.Serializable{
	
	@Column(name = "produto_id")
	private Integer produtoId;
	
	@Column(name = "cupom_id", nullable = false)
	private Integer cupomId;

	public Integer getProduto_id() {
		return produtoId;
	}

	public void setProduto_id(Integer produto_id) {
		this.produtoId = produto_id;
	}

	public Integer getCupom_id() {
		return cupomId;
	}

	public void setCupom_id(Integer cupom_id) {
		this.cupomId = cupom_id;
	}

	
	
}
