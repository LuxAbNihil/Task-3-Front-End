package org.demartino.videosharefe.manager;

import org.demartino.videosharefe.view.Login;
import org.demartino.videosharefe.view.UserAndVideoListContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class LoginManagerImpl implements LoginManager {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String restServiceApi = "http://localhost:8080/videosharingsite/";
	
	@Override
	public UserAndVideoListContainer login(Login login) 
	{
		HttpEntity<Login> request = new HttpEntity<>(login);
		ResponseEntity<UserAndVideoListContainer> response = restTemplate.exchange(restServiceApi + "/loginSubmit/", HttpMethod.POST, request, UserAndVideoListContainer.class);
		UserAndVideoListContainer userAndVideoListContainer = response.getBody();
		return userAndVideoListContainer;
	}
	
}