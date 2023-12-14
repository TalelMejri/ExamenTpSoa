package org.dsi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableMethodSecurity
@Controller
public class client_controller {
	
	@Autowired
	OAuth2AuthorizedClientService oauth2ClientService;
	
	@Autowired
	RestTemplate restTemplate;

	    @GetMapping("/")
	    public String suppliers(Model model,@AuthenticationPrincipal OidcUser principal
				) {
	    	 
			  Authentication authentication =
			  SecurityContextHolder.getContext().getAuthentication();
			  OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken)
			  authentication;
			  
			  OAuth2AuthorizedClient oauth2Client =
			  oauth2ClientService.loadAuthorizedClient(oauthToken.
			  getAuthorizedClientRegistrationId(), oauthToken.getName());
			  
			  String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
			  System.out.println("jwtAccessToken = " + jwtAccessToken);
			  
			  
			  System.out.println("Principal = " + principal);
			  
			  OidcIdToken idToken = principal.getIdToken(); 
			  String idTokenValue = idToken.getTokenValue(); 
			  System.out.println("idTokenValue = " + idTokenValue);
	    	  String url = "http://localhost:8888/SERVICE-SECURISE/allAlbum"; 
			  HttpHeaders headers = new HttpHeaders(); 
			  headers.add("Authorization", "Bearer " + jwtAccessToken);
			  HttpEntity<List<ALbum>> entity = new HttpEntity<>(headers);
			  ResponseEntity<List<ALbum>> responseEntity = restTemplate.exchange(url,
			  HttpMethod.GET, entity, new ParameterizedTypeReference<List<ALbum>>()
			  {});
			 // System.out.println("dddddddddddddddddddddddd"+responseEntity.getBody());
			  List<ALbum> pageSuppliers = responseEntity.getBody();
			  model.addAttribute("ALbum",pageSuppliers);
			  return "index";
	    }
	


}

class ALbum{
	 private Long id;
	
	 private String titre;

	 private List<Photo> Photos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Photo> getPhotos() {
		return Photos;
	}

	public void setPhotos(List<Photo> photos) {
		Photos = photos;
	}

	public ALbum(Long id, String titre, List<Photo> photos) {
		super();
		this.id = id;
		this.titre = titre;
		Photos = photos;
	}

	@Override
	public String toString() {
		return "ALbum [id=" + id + ", titre=" + titre + ", Photos=" + Photos + "]";
	}
	 
	 
}

class Photo {
	private Long id;
	private String dateCreation;
	private String dateModification;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getDateModification() {
		return dateModification;
	}
	public void setDateModification(String dateModification) {
		this.dateModification = dateModification;
	}
	public Photo(Long id, String dateCreation, String dateModification) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
	}
	@Override
	public String toString() {
		return "Photo [id=" + id + ", dateCreation=" + dateCreation + ", dateModification=" + dateModification + "]";
	}
	
}

