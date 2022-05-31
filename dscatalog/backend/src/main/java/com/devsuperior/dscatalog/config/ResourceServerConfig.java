package com.devsuperior.dscatalog.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Autowired
	private Environment env; //Ambiente de execução da aplicação
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };
	
	private static final String[] OPERATOR_OR_ADMIN = { "/products/**", "/categories/**" };
	
	private static final String[] ADMIN = { "/users/**" };
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);//Decodificar o token e analisar com o secret, expirado, se o token é válido
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//H2
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
			//Se o perfil for de teste. é para liberar o h2
		}
		
		
		http.authorizeRequests() //Autorizar requisições
		.antMatchers(PUBLIC).permitAll() //Permitindo a rota de login para todos
		.antMatchers(HttpMethod.GET, OPERATOR_OR_ADMIN).permitAll() //Liberando get para operador e admin
		.antMatchers(OPERATOR_OR_ADMIN).hasAnyRole("OPERATOR", "ADMIN") //Nesse rota operado e admin podem acessar
		.antMatchers(ADMIN).hasRole("ADMIN") //Só pode acessar esse vetor quem for admin
		.anyRequest().authenticated(); //Qualquer outra rota basta estar logado
	}
	
	
	
	
}
