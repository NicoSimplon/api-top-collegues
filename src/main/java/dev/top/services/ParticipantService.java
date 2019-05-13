package dev.top.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.top.dao.ParticipantRepository;
import dev.top.dto.ParticipantDTO;
import dev.top.dto.Vote;
import dev.top.entities.Participant;
import dev.top.exceptions.ParticipantNotFound;

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
				.map(p -> new ParticipantDTO(p.getEmail(), p.getNom(), p.getPrenoms(), p.getPhotoUrl(), p.getScore()))
				.collect(Collectors.toList());
	}
	
	/**
	 * Permet de retrouver un participant via son email
	 * 
	 * @param email
	 * @return Optional<Participant>
	 */
	public Optional<Participant> findParticipantByEmail (String email) {
		return repo.findById(email);
	}
	
	/**
	 * Répercupe un vote sur le score du participant concerné
	 * 
	 * @param vote
	 * @return List<ParticipantDTO> Renvoie le nouveau classement
	 */
	@Transactional
	public List<ParticipantDTO> voteForParticipant(Vote vote){
		
		Optional<Participant> participant = this.findParticipantByEmail(vote.getEmail());
		
		if(participant.isPresent()) {
			
			Participant p = participant.get();
			
			if (vote.getSensDuVote()) {
				
				p.setScore(p.getScore() + 100);
				
			} else {

				p.setScore(p.getScore() - 100);
				
			}
			
		} else {
			
			throw new ParticipantNotFound("Le collègue pour lequel vous avez voté n'existe pas.");
		
		}
		
		return this.findAllParticipants();
		
	}
	
}
