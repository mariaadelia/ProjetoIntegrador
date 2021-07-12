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

import br.org.generation.projetoIntegrador.model.Categoria;
import br.org.generation.projetoIntegrador.repository.CategoriaRepository;
import br.org.generation.projetoIntegrador.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping // FindAll
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}") // findById
	public ResponseEntity<Categoria> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/produto/{produto}") // Pesquisa pelo nome produto e ou serviço
	public ResponseEntity<List<Categoria>> getByProduto(@PathVariable String produto) {
		return ResponseEntity.ok(repository.findAllByProdutoServicosContainingIgnoreCase(produto));
	}

	@GetMapping("/chave/{chave}") // Pesquisa pela palavra-chave
	public ResponseEntity<List<Categoria>> getByPalavra(@PathVariable String chave) {
		return ResponseEntity.ok(repository.findAllByPalavraChaveContainingIgnoreCase(chave));
	}

	@PostMapping // Postando categoria
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria postCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postCategoria));
	}

	@PutMapping // Modificando Categoria
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria putCategoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(putCategoria));
	}

	@DeleteMapping("/{id}") // Deletando Categoria
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	//Categoria TT
	@GetMapping("/trendtopics")
	public ResponseEntity<List<Categoria>> getTrendTopics(){
		return ResponseEntity.ok(categoriaService.trendTopics());
	}
}