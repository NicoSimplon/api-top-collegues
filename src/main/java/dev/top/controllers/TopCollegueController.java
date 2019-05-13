package dev.top.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.dto.ParticipantDTO;
import dev.top.dto.Vote;
import dev.top.services.ParticipantService;

/**
 * Controlleur gérant les requêtes HTTP vers l'extérieur de l'API
 * 
 * @author Nicolas
 *
 */
@RestController
@RequestMapping("/top-collegues")
public class TopCollegueController {

	@Autowired
	ParticipantService service;
	
	/**
	 * Récupère les infos des collègues participants
	 * 
	 * @return List<ParticipantDTO>
	 */
	@GetMapping
	@Secured("ROLE_USER")
    public List<ParticipantDTO> findAllParticipant() {

        return service.findAllParticipants();
    }
	
	/**
	 * Récupère un vote et retourne la liste des participants
	 * avec le classement mis à jour
	 * 
	 * @param vote
	 * @return
	 */
	@PostMapping
	@Secured("ROLE_USER")
    public ResponseEntity<List<ParticipantDTO>> vote(@RequestBody Vote vote) {

		List<ParticipantDTO> listesAJour = service.voteForParticipant(vote);
        
        return ResponseEntity.status(HttpStatus.OK).body(listesAJour);
    }
	
}
