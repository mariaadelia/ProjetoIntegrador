package br.org.generation.projetoIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	@Size(min = 2, max = 100)
	private String produto_servicos;
	
	@Size(min = 2, max = 100)
	private String palavra_chave;
	
	@NotNull(message = "Este campo não pode ser vazio!")
	@Size(min = 50, max = 1250, message = "Este campo precisa de no mínimo 50 e no máximo 1250 caracteres!")
	private String descricao;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduto_servicos() {
		return produto_servicos;
	}
	public void setProduto_servicos(String produto_servicos) {
		this.produto_servicos = produto_servicos;
	}
	public String getPalavra_chave() {
		return palavra_chave;
	}
	public void setPalavra_chave(String palavra_chave) {
		this.palavra_chave = palavra_chave;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
