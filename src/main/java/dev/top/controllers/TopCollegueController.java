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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.top.dto.ClassementDTO;
import dev.top.dto.ParticipantDTO;
import dev.top.dto.Vote;
import dev.top.entities.Classement;
import dev.top.services.ClassementService;
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
	ParticipantService servicePart;
	
	@Autowired
	ClassementService serviceClass;
	
	/**
	 * Récupère les infos des collègues participants
	 * 
	 * @return List<ParticipantDTO>
	 */
	@GetMapping
	@Secured("ROLE_USER")
    public List<ParticipantDTO> findAllParticipant() {

        return servicePart.findAllParticipants();
    }
	
	@PostMapping
	@Secured("ROLE_USER")
    public ResponseEntity<ClassementDTO> vote(@RequestBody Vote vote) {

        ClassementDTO classement = serviceClass.voteForParticipant(vote);
        
        return ResponseEntity.status(HttpStatus.OK).body(classement);
    }
	
	@GetMapping("/classement")
	@Secured("ROLE_USER")
	public ResponseEntity<ClassementDTO> getClassementByEmail(@RequestParam String email){
		
		Classement classement = serviceClass.findClassementByEmail(email).get();
		ClassementDTO classementDto = new ClassementDTO(classement.getScore(), classement.getParticipant().getEmail());
		
		return ResponseEntity.status(HttpStatus.OK).body(classementDto);
		
	}
	
}
