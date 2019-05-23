package org.demartino.videosharefe.manager;

import java.util.List;

import org.demartino.videosharefe.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class UserManagerImpl implements UserManager {

	@Autowired
	private RestTemplate restTemplate;
	
	private String requestServiceApi = "http://localhost:8080/videosharingsite/";
	
	public User createUser(User user) {
		HttpEntity<User> request = new HttpEntity<>(user);
		System.out.println("USER IS: " + user);
		System.out.println("REQUEST IS: " + request);
		ResponseEntity<User> response = restTemplate.exchange(requestServiceApi + "addUser/", HttpMethod.POST, request, User.class);
		//ResponseEntity<User> response = restTemplate.postForEntity(requestServiceApi + "addUser/", request, User.class);
		User userToBeReturned = response.getBody();
		return userToBeReturned;
	}

	public boolean deleteUserByUsername(String username) {
		HttpEntity<String> request = new HttpEntity<>(username);
		ResponseEntity<Boolean> response = restTemplate.exchange(requestServiceApi + "deleteUser/" + username, HttpMethod.DELETE, request, Boolean.class);
		boolean userHasBeenDeleted = response.getBody();
		return userHasBeenDeleted;
	}
	
	public User findUserByUsername(String username) {
		HttpEntity<String> request = new HttpEntity<>(username);
		ResponseEntity<User> response = restTemplate.exchange(requestServiceApi + "getUserByUsername/" +username, HttpMethod.GET, request, User.class);
		User userToBeReturned = response.getBody();
		return userToBeReturned;
	}
	
	public User updateUser(User user) {
		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = restTemplate.exchange(requestServiceApi + "updateUser/" + user.getUsername(), HttpMethod.PUT, request, User.class);
		User userToBeReturned = response.getBody();
		return userToBeReturned;
	}
	
	public List<User> getAllUsers() {
		HttpEntity<Void> request = new HttpEntity<Void>(null, new HttpHeaders());
		ResponseEntity<List<User>> response = restTemplate.exchange(requestServiceApi + "getAllUsers/", HttpMethod.GET, request, new ParameterizedTypeReference<List<User>>() {});
		List<User> users = response.getBody();
		return users;
		
	}
}
