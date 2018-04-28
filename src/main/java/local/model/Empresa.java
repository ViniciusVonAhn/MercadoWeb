package local.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Empresa extends GenericModel{

	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cnpj;

	@OneToOne(mappedBy = "empresa")
	private Cupom cupom;

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

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	
	
}
