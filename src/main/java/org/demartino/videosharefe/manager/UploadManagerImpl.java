package org.demartino.videosharefe.manager;

import java.util.List;

import org.demartino.videosharefe.view.Upload;
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
public class UploadManagerImpl implements UploadManager{

	@Autowired
	private RestTemplate restTemplate;
	
	private String restServiceApi = "http://localhost:8080/videosharingsite/";
	
	public Upload createVideo(Upload upload, String username) {
		HttpEntity<Upload> request = new HttpEntity<Upload>(upload);
		ResponseEntity<Upload> response = restTemplate.exchange(restServiceApi + "/upload/" + username, HttpMethod.POST, request, Upload.class);
		return response.getBody();
	}

	
	public boolean deleteVideoById(Long id) {
		ResponseEntity<Boolean> response = restTemplate.exchange(restServiceApi + "/deleteVideo/" + id, HttpMethod.DELETE, new HttpEntity<Void>(null, new HttpHeaders()), Boolean.class);
		return response.getBody();
	}

	
	public Upload findVideoByTitle(String title) {
		ResponseEntity<Upload> response = restTemplate.exchange(restServiceApi + "/findVideoByTitle/" + title, HttpMethod.GET, new HttpEntity<Void>(null, new HttpHeaders()), Upload.class);
		return response.getBody();
	}
	
	public Upload updateVideo(Upload upload, String username) {
		HttpEntity<Upload> request = new HttpEntity<>(upload);
		ResponseEntity<Upload> response = restTemplate.exchange(restServiceApi + "/updateVideo/" + username, HttpMethod.PUT, request, Upload.class);
		return response.getBody();
	}
	
	public List<Upload> getAllVideosForUser(String username) {
		HttpEntity<Void> request = new HttpEntity<>(null, new HttpHeaders());
		ResponseEntity<List<Upload>> response = restTemplate.exchange(restServiceApi + "/getAllVideosForUser/" + username, HttpMethod.GET, request, new ParameterizedTypeReference<List<Upload>>(){});  
		return response.getBody();
	}

}
 