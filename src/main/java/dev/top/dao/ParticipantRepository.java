package dev.top.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.top.entities.Participant;


/**
 * Interface héritant de JpaRepository pour la gestion du CRUD relatif aux participants
 * 
 * @author Nicolas
 *
 */
public interface ParticipantRepository extends JpaRepository<Participant, String> {

	@Query("select p from Participant p order by p.score desc")
	public Optional<Participant> findAllOrderByScore();
	
}
