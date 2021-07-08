package br.org.generation.projetoIntegrador.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
		.withUser("projetoredeantonias@gmail.com").password(passwordEncoder().encode("admin001")).authorities("ROLE_ADMIN");
		
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	//Pode colocar visualizar qualquer coisa, menos o carrinho de compras
	protected void configure (HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
		.antMatchers("/usuario/logar").permitAll()
		.antMatchers("/usuario/cadastrar").permitAll()
		.antMatchers(HttpMethod.GET ,"/produtosservicos").permitAll()
		.antMatchers(HttpMethod.GET ,"/categoria").permitAll()
		.antMatchers("/").permitAll() //Para que a home seja visível para todes(sem ser necessário estar logado)
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
	}

}
