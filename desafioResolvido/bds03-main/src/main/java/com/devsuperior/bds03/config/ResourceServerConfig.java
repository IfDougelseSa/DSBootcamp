package com.devsuperior.bds03.config;

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
	
	private static final String[] OPERATOR_GET = { "/departments/**", "/employees/**" };
	
	
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
		.antMatchers(HttpMethod.GET, OPERATOR_GET).hasAnyRole("OPERATOR", "ADMIN")
		.anyRequest().hasAnyRole("ADMIN");
	}
	
	
	
	
}
