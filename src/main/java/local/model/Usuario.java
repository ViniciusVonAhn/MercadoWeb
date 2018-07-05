package local.model;

import java.util.List;

import javax.persistence.*;


@Entity
public class Usuario extends GenericModel{

	@Column
	private String nome;
	@Column
    private String senha;
	@Column
    private String role;

    public String getNome() {
        return nome;
    }

    public void setEmail(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
