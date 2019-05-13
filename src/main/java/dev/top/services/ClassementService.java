package dev.top.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.top.dao.ClassementRepository;
import dev.top.dao.ParticipantRepository;
import dev.top.dto.ClassementDTO;
import dev.top.dto.Vote;
import dev.top.entities.Classement;
import dev.top.entities.Participant;
import dev.top.exceptions.ParticipantNotFound;

@Service
public class ClassementService {

	@Autowired
	ClassementRepository repo;
	
	@Autowired
	ParticipantRepository repo2;
	
	@Transactional
	public ClassementDTO voteForParticipant(Vote vote){
		
		Optional<Participant> participant = repo2.findByEmail(vote.getEmail());
		
		ClassementDTO classementDto = new ClassementDTO();
		
		String email = participant.get().getEmail();
		
		if(participant.isPresent()) {
			
			classementDto.setEmail(email);
			Classement classement = this.findClassementByEmail(email).get();
			
			if (vote.getSensDuVote()) {
				
				classement.setScore(classement.getScore() + 100);
				classementDto.setScore(classement.getScore());
				
			} else {

				classement.setScore(classement.getScore() - 100);
				classementDto.setScore(classement.getScore());
				
			}
			
		} else {
			
			throw new ParticipantNotFound("Le collègue pour lequel vous avez voté n'existe pas.");
		
		}
		
		return classementDto;
		
	}
	
	public Optional<Classement> findClassementByEmail (String email) {
		return repo.findByEmail(email);
	}
	
	public void initialClassement (Classement classement) {
		repo.save(classement);
	}
	
}
