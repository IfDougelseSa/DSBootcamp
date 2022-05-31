package com.devsuperior.dscatalog.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.UserRepository;

@Component
public class JwtTokenEnhancer implements TokenEnhancer{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		/*
		 * Class para adicionar mais informações no token
		 * O metodo serve para adicionar as informacoes e implementar 
		 */
		
		User user = userRepository.findByEmail(authentication.getName());
		//Authentication para buscar as informacoes
		Map<String, Object> map = new HashMap<>();
		map.put("userFirstName", user.getFirstName());
		map.put("userId", user.getId());
		//accessToken para inserir no token
		
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;//downcasting
		//Downcasting necessario pois apenas ele tem o metodo de adicionar
		token.setAdditionalInformation(map);
		
		return accessToken;
	}

}
