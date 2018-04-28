package local.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CupomID implements java.io.Serializable{
	
	@Column(name = "produto_id", nullable = false)
	private Integer produto_id;
	
	@Column(name = "cupom_id", nullable = false)
	private Integer cupom_id;

	public Integer getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}

	public Integer getCupom_id() {
		return cupom_id;
	}

	public void setCupom_id(Integer cupom_id) {
		this.cupom_id = cupom_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cupom_id == null) ? 0 : cupom_id.hashCode());
		result = prime * result + ((produto_id == null) ? 0 : produto_id.hashCode());
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
		CupomID other = (CupomID) obj;
		if (cupom_id == null) {
			if (other.cupom_id != null)
				return false;
		} else if (!cupom_id.equals(other.cupom_id))
			return false;
		if (produto_id == null) {
			if (other.produto_id != null)
				return false;
		} else if (!produto_id.equals(other.produto_id))
			return false;
		return true;
	}
	
	

}
