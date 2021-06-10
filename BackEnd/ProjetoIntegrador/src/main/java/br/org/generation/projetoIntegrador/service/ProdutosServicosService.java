package br.org.generation.projetoIntegrador.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.org.generation.projetoIntegrador.model.ProdutosServicos;
import br.org.generation.projetoIntegrador.repository.ProdutosServicosRepository;



@Service
public class ProdutosServicosService {

	// Injeção de dependência (Produto) 
	@Autowired
	private ProdutosServicosRepository produtoRepository;
		
	public ProdutosServicos curtir(Long id) {
		
		ProdutosServicos produto = buscarProdutoPeloId(id);

		produto.setCurtir(produto.getCurtir() + 1); //Adicionando likes

		return produtoRepository.save(produto);
	
	}
	
public ProdutosServicos undocurtir(Long id) {
		
	ProdutosServicos produto = buscarProdutoPeloId(id);
		
		if (produto.getCurtir() > 0) {
			
			produto.setCurtir(produto.getCurtir() - 1);// Subtraindo likes
			
		}else {
			
			produto.setCurtir(0);
		
		}

		return produtoRepository.save(produto);
	
	}
	public ProdutosServicos dislike(Long id) {
		
		ProdutosServicos produto = buscarProdutoPeloId(id);
		


		produto.setDislike(produto.getDislike() + 1);//Adicionando dislike
		
	

		return produtoRepository.save(produto);
	
	}
	
public ProdutosServicos undoDislike(Long id) {
		

		ProdutosServicos produto = buscarProdutoPeloId(id);
		

		if (produto.getDislike() > 0) {
			
			produto.setDislike(produto.getDislike() - 1);//Subtraindo dislike
			
		}else {
			
			produto.setDislike(0);
		
		}


		return produtoRepository.save(produto);
	
	}
	private ProdutosServicos buscarProdutoPeloId(Long id) {
		
        ProdutosServicos produtoSalvo = produtoRepository.findById(id).orElse(null);
        if (produtoSalvo == null) {
             
        	throw new EmptyResultDataAccessException(1);
        } 
        
        	return produtoSalvo;
	
}
}