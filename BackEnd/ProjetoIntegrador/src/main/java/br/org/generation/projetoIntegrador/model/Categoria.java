package br.org.generation.projetoIntegrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	@Size(min = 2, max = 100)
	private String produtoServicos;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	@Size(min = 2, max = 100)
	private String categoria;
	
	@Size(min = 2, max = 100)
	private String palavraChave;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	@Size(min = 50, max = 1250, message = "Este campo precisa de no mínimo 50 e no máximo 1250 caracteres!")
	private String descricao;
	
	@Transient
	private int qtdCategoria;
	
	//Relacionamento
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutosServicos> servicos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProdutoServicos() {
		return produtoServicos;
	}

	public void setProdutoServicos(String produtoServicos) {
		this.produtoServicos = produtoServicos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProdutosServicos> getServicos() {
		return servicos;
	}

	public void setServicos(List<ProdutosServicos> servicos) {
		this.servicos = servicos;
	}

	public int getQtdCategoria() {
		return qtdCategoria;
	}

	public void setQtdCategoria(int qtdCategoria) {
		this.qtdCategoria = qtdCategoria;
	}
	
	
	//
	
	
	
	
	
	
}
