package local.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Empresa extends GenericModel{

	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cnpj;
	@Column(name="cupom_empresa", nullable=false)
	@OneToMany(mappedBy = "empresa")
	private List<Cupom> cupomListEmpresa;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public List<Cupom> getCupomListEmpresa() {
		return cupomListEmpresa;
	}
	public void setCupomListEmpresa(List<Cupom> cupomListEmpresa) {
		this.cupomListEmpresa = cupomListEmpresa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((cupomListEmpresa == null) ? 0 : cupomListEmpresa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (cupomListEmpresa == null) {
			if (other.cupomListEmpresa != null)
				return false;
		} else if (!cupomListEmpresa.equals(other.cupomListEmpresa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
