package com.devsuperior.dscatalog.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.devsuperior.dscatalog.components.JwtTokenEnhancer;

@Configuration
@EnableAuthorizationServer// Ela que vai dizer que essa class vai representar o authrization server do oauth
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	
	//Variaveis de ambientes externalizadas
	@Value("${security.oauth2.client.client-id}")
	private String clientId;
	
	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;
	
	@Value("${jwt.duration}")
	private Integer jwtDuration;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/*
	 * 4 beans necessarios para o authorization server.
	 */
	
	@Autowired//Injetando as info adicionais do token
	private JwtTokenEnhancer tokenEnhancer;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
		//
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//Como que vai ser a autenticacao e os dados dos clientes
		//Credenciais da aplicacao
		clients.inMemory()
		.withClient(clientId)//Nome da aplicacao. Aplicacao web vai ter que informar quando for acessar o backend
		.secret(passwordEncoder.encode(clientSecret))//Client secret/ senha da aplicacao
		.scopes("read", "write")//Como vai ser o acesso? De leitura, escrita...
		.authorizedGrantTypes("password")//tipos de acessos
		.accessTokenValiditySeconds(jwtDuration);//tempo de duração do token
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		TokenEnhancerChain chain = new TokenEnhancerChain();
		chain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));
		// Quem que vai autorizar e qual vai ser o formato do token
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore)// quem vai processar o token
		.accessTokenConverter(accessTokenConverter)
		.tokenEnhancer(chain);
	}
	
	
	
}
