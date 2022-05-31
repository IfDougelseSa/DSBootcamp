package com.devsuperior.dscatalog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/*
 * Bean (componente) do DCrypt para que possa ser usado dentro do userservice
 * Classe de configuração guardar conf do app como um todo
 * responsavel por manter conf, criar componentes especificos
 */
@Configuration
public class AppConfig {
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	//Componente do spring para ser gerenciado, em vez de ser uma annotation de class
	@Bean //é uma annotation de método
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*/
	 * Estes dois beans são objetos capazes de acessar um token JWT.
	 * Ler, decodficar, criar decotificando o mesmo
	 * Vão ser injetados no autorizathion server
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("jwtSecret");
		return tokenConverter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
}
