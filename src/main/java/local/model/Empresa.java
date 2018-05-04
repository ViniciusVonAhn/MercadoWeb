package local.model;

import javax.persistence.*;

@Entity
public class Empresa extends GenericModel{

	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cnpj;

	@OneToOne(mappedBy = "empresa")
	private Venda venda;

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

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	
	
}
