package br.org.generation.projetoIntegrador.service;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.generation.projetoIntegrador.model.Usuario;
import br.org.generation.projetoIntegrador.model.UsuarioLogin;
import br.org.generation.projetoIntegrador.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	//Cadastro de usuário
	public Optional<Usuario> cadastrarUsuario(Usuario email) {
		
		if(repository.findByEmail(email.getEmail()).isPresent()) //Verificar se o usuário existe (email)
			return null;
		
		int idade = Period.between(email.getDataAniversario(), LocalDate.now()).getYears(); //Verificar a idade do usuário 
		if(idade <= 16)
			return null;
		
		//Encriptar o password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(email.getSenha());
		email.setSenha(senhaEncoder);
		
		return Optional.of(repository.save(email));
	}
	
	//Atualizar cadastro
	public Optional<Usuario> atualizarUsuario (Usuario email){
		/*if(repository.findByEmail(email.getEmail()).isPresent())
			return null; trocar*/
		
		//Encriptar o password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(email.getSenha());
		email.setSenha(senhaEncoder);
		
		return Optional.of(repository.save(email));
	}
	
	//Logar
	public Optional<UsuarioLogin>login (Optional<UsuarioLogin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByEmail(user.get().getEmail());
		
		if(usuario.isPresent()) {
			
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {//Para checar se é a mesma senhada cadastrada
				
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII"))); //Criptografia da senha
				String authHeader = "Basic " + new String(encodeAuth); //Token
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());
				
				return user;
			}
		}
		
		return null;
	}
	
	
	
	

}
