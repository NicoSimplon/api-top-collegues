package dev.top.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.top.entities.Classement;

/**
 * Interface héritant de JpaRepository pour la gestion du CRUD relatif au classement
 * du jeu Top Collègue
 * 
 * @author Nicolas
 *
 */
public interface ClassementRepository extends JpaRepository<Classement, String> {

}
