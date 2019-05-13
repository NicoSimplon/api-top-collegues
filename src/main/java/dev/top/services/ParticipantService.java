package dev.top.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.top.dao.ParticipantRepository;
import dev.top.dto.ParticipantDTO;
import dev.top.entities.Participant;

@Service
public class ParticipantService {

	@Autowired
	ParticipantRepository repo;
	
	/**
	 * Permet de sauvegarder un nouveau participant en base de données
	 * 
	 * @param participant
	 */
	public void saveNewParticipant(Participant participant) {
		
		// Si le participant est déjà enregistré, il ne sera pas enregistré lors d'une nouvelle connexion
		if (! this.findParticipantByEmail(participant.getEmail()).isPresent()) {
			repo.save(participant);			
		}
	}
	
	/**
	 * Permet de récupérer les infos de tous les participants
	 * 
	 * @return List<ParticipantDTO>
	 */
	public List<ParticipantDTO> findAllParticipants() {
		return repo.findAll().stream()
				.map(p -> new ParticipantDTO(p.getEmail(), p.getNom(), p.getPrenoms(), p.getPhotoUrl()))
				.collect(Collectors.toList());
	}
	
	/**
	 * Permet de retrouver un participant via son email
	 * 
	 * @param email
	 * @return Optional<Participant>
	 */
	public Optional<Participant> findParticipantByEmail (String email) {
		return repo.findByEmail(email);
	}
	
}
