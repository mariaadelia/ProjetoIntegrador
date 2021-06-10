package br.org.generation.projetoIntegrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.projetoIntegrador.model.Usuario;
import br.org.generation.projetoIntegrador.model.UsuarioLogin;
import br.org.generation.projetoIntegrador.repository.UsuarioRepository;
import br.org.generation.projetoIntegrador.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository repository;
	
	//Find All
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	//Find All By Nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	
	//Cadastro
	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<Usuario>> cadastrar (@RequestBody Usuario cadastro){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(cadastro));
	}
	
	
	//Atualizar Cadastro
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> alterar(@RequestBody Usuario alterarCadastro){
		Optional<Usuario> usuario = usuarioService.atualizarUsuario(alterarCadastro);
		try {
			return ResponseEntity.ok(usuario.get());
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	//Login
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> login(@RequestBody Optional<UsuarioLogin>logar){
		return usuarioService.login(logar).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

}
