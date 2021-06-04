package br.org.generation.projetoIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos_servicos")
public class ProdutosServicos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(min = 2, max = 100) // mensagem de erro front end
	private String nomeProdutosServicos;
	@NotNull
	private double preco;
	private int estoqueVendedor;
	@NotNull
	@Size(min = 50, max = 1250)
	private String descricao;
	@Size(max = 1250)
	private String midias;
	private int curtir;
	private int dislike;

	// Relacionamento
	@ManyToOne
	@JsonIgnoreProperties("servicos")
	private Categoria categoria;

	@ManyToOne
	@JsonIgnoreProperties("produtosServicos")
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProdutosServicos() {
		return nomeProdutosServicos;
	}

	public void setNomeProdutosServicos(String nomeProdutosServicos) {
		this.nomeProdutosServicos = nomeProdutosServicos;
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

	public int getCurtir() {
		return curtir;
	}

	public void setCurtir(int curtir) {
		this.curtir = curtir;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//

}
