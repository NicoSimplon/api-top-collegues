package dev.top.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.top.entities.Participant;


/**
 * Interface héritant de JpaRepository pour la gestion du CRUD relatif aux participants
 * 
 * @author Nicolas
 *
 */
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

	@Query("select p from Participant p where p.email = :email")
	public Optional<Participant> findByEmail(@Param("email") String email);
	
}
