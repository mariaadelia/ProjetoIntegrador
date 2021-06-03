package br.org.generation.projetoIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(min = 2, max = 100) // mensagem de erro front end
	private String nomeProdutoServico;
	@NotNull
	private double preco;
	private int estoqueVendedor;
	@NotNull
	@Size(min = 50, max = 1250)
	private String descricao;
	@Size(max = 1250)
	private String midias;
	private int like;
	private int dislike;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProdutoServico() {
		return nomeProdutoServico;
	}

	public void setNomeProdutoServico(String nomeProdutoServico) {
		this.nomeProdutoServico = nomeProdutoServico;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoqueVendedor() {
		return estoqueVendedor;
	}

	public void setEstoqueVendedor(int estoqueVendedor) {
		this.estoqueVendedor = estoqueVendedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMidias() {
		return midias;
	}

	public void setMidias(String midias) {
		this.midias = midias;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

}
