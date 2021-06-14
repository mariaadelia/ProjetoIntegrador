package br.org.generation.projetoIntegrador.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	//Mensagens de erro
	private static List<Response> responseMessageForGET(){
		return new ArrayList<Response>() {

			private static final long serialVersionUID = 1L;
			
			{
				add(new ResponseBuilder().code("200")
						.description("Sucesso!").build());
				add(new ResponseBuilder().code("201")
						.description("Objeto Criado!").build());
				add(new ResponseBuilder().code("401")
						.description("Não Autorizado!").build());
				add(new ResponseBuilder().code("403")
						.description("Proibido!").build());
				add(new ResponseBuilder().code("404")
						.description("Não Encontrado!").build());
				add(new ResponseBuilder().code("500")
						.description("Erro!").build());
				
			}
			
		};
	}
	
	//Contatos do projeto
	private static Contact contact() {
		return new Contact("Márcio Ribeiro, Maria Adélia de Campos, Natália Sabino, Yoshimitsu Miyahira"
				, "https://github.com/mariaadelia/ProjetoRedeAntonias.git", "projetoredeantonias@gmail.com");
	}
	
	//Informação da API
	public static ApiInfo metadata() {
		return new ApiInfoBuilder ()
				.title("API - Rede Antônias")
				.description("Projeto Integrador - Rede Antônias")
				.version ("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/mariaadelia/ProjetoRedeAntonias/blob/master/LICENSE")
				.contact(contact())
				.build();
	}
	
	//Conexão com a controller
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors
					.basePackage("br.org.generation.projetoIntegrador.controller"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(metadata())
			.useDefaultResponseMessages(false)
			.globalResponses(HttpMethod.GET, responseMessageForGET());
	}

}
