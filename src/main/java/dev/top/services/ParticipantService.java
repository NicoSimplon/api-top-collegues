package dev.top.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.top.dao.ParticipantRepository;
import dev.top.entities.Participant;

@Service
public class ParticipantService {

	@Autowired
	ParticipantRepository repo;
	
	public void saveNewParticipant(Participant participant) {
		repo.save(participant);
	}
	
	
}
