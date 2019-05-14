package dev.top.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.top.dao.ParticipantRepository;
import dev.top.dao.VoteRepository;
import dev.top.dto.ParticipantDTO;
import dev.top.dto.VoteDTO;
import dev.top.entities.Participant;
import dev.top.entities.Vote;
import dev.top.exceptions.ParticipantNotFound;
import dev.top.exceptions.VoteInvalideException;

@Service
public class ParticipantService {

	@Autowired
	ParticipantRepository repo;

	@Autowired
	VoteRepository repoVote;

	/**
	 * Permet de sauvegarder un nouveau participant en base de données
	 * 
	 * @param participant
	 */
	public void saveNewParticipant(Participant participant) {

		// Si le participant est déjà enregistré, il ne sera pas enregistré lors
		// d'une nouvelle connexion
		if (!this.findParticipantByEmail(participant.getEmail()).isPresent()) {
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
	public Optional<Participant> findParticipantByEmail(String email) {
		return repo.findById(email);
	}

	/**
	 * Répercupe un vote sur le score du participant concerné
	 * 
	 * @param vote
	 * @return List<ParticipantDTO> Renvoie le nouveau classement
	 */
	@Transactional
	public List<ParticipantDTO> voteForParticipant(VoteDTO vote) {
		
		Optional<Participant> participant = this.findParticipantByEmail(vote.getEmail());

		Vote vot = new Vote(vote.getEmail(), vote.getSensDuVote(), SecurityContextHolder.getContext().getAuthentication().getName());
		
		if(participant.isPresent()) {
			
			if(vot.getEmailDuCollegue().equals(vot.getEmailDuVotant())){
				throw new VoteInvalideException("Vous ne pouvez pas voter pour vous même");
			}
				
			if(repoVote.findVoteByEmail(vot.getEmailDuVotant(), vot.getEmailDuCollegue()) > 0) {
				throw new VoteInvalideException("Vous ne pouvez pas voter pour le même collègue plusieurs fois");
			}
				repoVote.save(vot);
					
				Participant part = participant.get();
					
				part.setScore(
					(repoVote.findVotePositifByEmail(vot.getEmailDuCollegue()) - repoVote.findVoteNegatifByEmail(vot.getEmailDuCollegue())) * 100
				);				
				
		} else {
			
			throw new ParticipantNotFound("Le collègue pour lequel vous avez voté n'existe pas.");
		
		}
		
		return this.findAllParticipants();
		
	}

}
