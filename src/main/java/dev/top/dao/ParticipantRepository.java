package dev.top.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.top.entities.Participant;


/**
 * Interface héritant de JpaRepository pour la gestion du CRUD relatif aux participants
 * 
 * @author Nicolas
 *
 */
public interface ParticipantRepository extends JpaRepository<Participant, String> {
	
}
