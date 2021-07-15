package br.org.generation.projetoIntegrador.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	@Size(min = 5, max = 100, message = "Este campo precisa de no mínimo 5 e no máximo 100 caracteres!")
	private String nome ;
	
	@Nullable
	private String foto;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	@Email
	@Size(max = 256, message = "Este campo precisa de no máximo 256 caracteres!")
	private String email;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	@Size(min = 8, max = 60, message = "Este campo precisa de no mínimo 8 e no máximo 60 caracteres!")
	private String senha;
	
	@NotNull(message = "Este campo não pode ser nulo")
	private String vendedor;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	private LocalDate dataAniversario;
	
	//Relacionamento
	
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<ProdutosServicos> produtosServicos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public LocalDate getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(LocalDate dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public List<ProdutosServicos> getProdutosServicos() {
		return produtosServicos;
	}

	public void setProdutosServicos(List<ProdutosServicos> produtosServicos) {
		this.produtosServicos = produtosServicos;
	}

	
	
	//

	

}
