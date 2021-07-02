package br.org.generation.projetoIntegrador.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.generation.projetoIntegrador.model.Categoria;
import br.org.generation.projetoIntegrador.repository.CategoriaRepository;
import br.org.generation.projetoIntegrador.repository.ProdutosServicosRepository;

@Service
public class CategoriaService {
	//Injetar os dois repositórios, o de Tema e o de Postagem
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutosServicosRepository produtosServicosRepository;
	
	public List<Categoria> trendTopics(){
		
		//criar primeiro uma lista contendo todos os temas cadastrados
		List<Categoria> categorias = categoriaRepository.findAll();
		
		//com o for, iremos percorrer toda a lista e contar os posts de cada tema e guardar no atributo qtdTemas
		for(Categoria categoria : categorias) {
			categoria.setQtdCategoria(produtosServicosRepository.countProduto(categoria.getId()));//
		}
		
		//Ordenando a List gerada
		Collections.sort(categorias, Collections.reverseOrder(Comparator.comparing(Categoria::getQtdCategoria)));
		
		return categorias;
	
	}

}
