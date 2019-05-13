package dev.top.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.top.entities.Classement;

/**
 * Interface héritant de JpaRepository pour la gestion du CRUD relatif au classement
 * du jeu Top Collègue
 * 
 * @author Nicolas
 *
 */
public interface ClassementRepository extends JpaRepository<Classement, Integer> {

	@Query("select c from Classement c where c.participant.email = :email")
	public Optional<Classement> findByEmail(@Param("email") String email);
	
}
