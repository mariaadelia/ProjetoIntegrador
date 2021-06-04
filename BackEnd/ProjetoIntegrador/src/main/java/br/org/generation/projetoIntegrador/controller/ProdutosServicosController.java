package br.org.generation.projetoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.projetoIntegrador.model.ProdutosServicos;
import br.org.generation.projetoIntegrador.repository.ProdutosServicosRepository;

@RestController
@RequestMapping("/produtosservicos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosServicosController {
	
	@Autowired
	private ProdutosServicosRepository repository;
	
	@GetMapping //Find all
	public ResponseEntity<List<ProdutosServicos>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //Find by Id
	public ResponseEntity<ProdutosServicos> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}") //Find By Nome Produtos e Serviços
	public ResponseEntity<List<ProdutosServicos>> GetByNomeProdutosServicos(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeProdutosServicosContainingIgnoreCase(nome));
	}
	
	@PostMapping //Post
	public ResponseEntity<ProdutosServicos> postProdutosServicos(@RequestBody ProdutosServicos postProdutosServicos){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postProdutosServicos));
	}
	
	@PutMapping //Put
	public ResponseEntity<ProdutosServicos> putProdutosServicos(@RequestBody ProdutosServicos putProdutosServicos){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(putProdutosServicos));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProdutosServicos(@PathVariable long id) {
		repository.deleteById(id);
	}

}
