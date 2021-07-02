package br.org.generation.projetoIntegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.generation.projetoIntegrador.model.ProdutosServicos;

@Repository
public interface ProdutosServicosRepository extends JpaRepository<ProdutosServicos, Long>{
	
	public List<ProdutosServicos> findAllByNomeProdutosServicosContainingIgnoreCase(String nome);
	
	@Query(value = "select count(categoria_id) from tb_produtos_servicos where categoria_id = :id", nativeQuery = true)
	public int countProduto(@Param("id") long id);
	
}
