package dev.top.controllers;



import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.dto.InfosAuthentification;
import dev.top.dto.UtilisateurConnecte;
import dev.top.entities.Participant;
import dev.top.services.ParticipantService;

@RestController
public class AuthController {
	
	@Value("${jwt.expires_in}")
	private Integer EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Value("${jwt.secret}")
	private String SECRET;
	
	@Autowired
	private ParticipantService service;
	
	@Autowired
	RestTemplate rt;
	
	UtilisateurConnecte userCo;

	@PostMapping(value = "/auth")
	@Secured(value = "ROLE_USER")
	public ResponseEntity authenticate(@RequestBody @Valid InfosAuthentification authenticationRequest,
			HttpServletResponse response, BindingResult bindingResult) throws URISyntaxException {
		
		if (bindingResult.hasErrors()) {
			
			throw new BadCredentialsException("Les données de connexions sont erronnées");
		
		}
		
		// On se connecte
		ResponseEntity<UtilisateurConnecte> respHttp = rt.postForEntity("https://nicolas-collegues-api.herokuapp.com/auth", authenticationRequest, UtilisateurConnecte.class);
		
		// On récupère les infos du collègue dont l'url de sa photo
		ResponseEntity<Participant> respHttp2 = rt.exchange(RequestEntity
				.get(new URI("https://nicolas-collegues-api.herokuapp.com/email"))
				.header("Cookie", respHttp.getHeaders().getFirst("Set-Cookie"))
				.build(), Participant.class);
		
		Participant participant = respHttp2.getBody();
		
		String urlPhoto = authenticationRequest.getPhotoUrl();
		
		// Si le participant a renseigné une url de photo valide, on l'utilise
		if ((urlPhoto != null) && (urlPhoto.length() > 6) && (urlPhoto.startsWith("http"))) {
			participant.setPhotoUrl(urlPhoto);
		}
		
		// On appelle le service permettant d'enregistrer le participant
		service.saveNewParticipant(participant);
		
		String jetonJWT = respHttp.getHeaders().getFirst("Set-Cookie").split(";")[0].split("=")[1];
		
		Cookie authCookie = new Cookie(TOKEN_COOKIE, jetonJWT);
		authCookie.setHttpOnly(true);
		authCookie.setMaxAge(EXPIRES_IN * 1000);
		authCookie.setPath("/");
		response.addCookie(authCookie);

		this.userCo = respHttp.getBody();
		
		return ResponseEntity.ok().body(
				this.userCo
		);

	}
	
	@GetMapping(value = "/me")
	public ResponseEntity<UtilisateurConnecte> getUserConnecte() {
		return ResponseEntity.status(HttpStatus.OK).body(this.userCo);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity mauvaiseInfosConnexion(BadCredentialsException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
}
