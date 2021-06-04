package br.org.generation.projetoIntegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.projetoIntegrador.model.ProdutosServicos;

@Repository
public interface ProdutosServicosRepository extends JpaRepository<ProdutosServicos, Long>{
	
	public List<ProdutosServicos> findAllByNomeProdutosServicosContainingIgnoreCase(String nome);
	
}
