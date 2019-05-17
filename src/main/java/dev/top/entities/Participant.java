package dev.top.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Entité représentant un participant au jeu Top Collègue
 * 
 * @author Nicolas
 *
 */
@Entity
@Table(name = "participants")
public class Participant {

	@Id
	@Email
	@Size(min = 3)
	@NotEmpty(message = "L'email ne peut pas être null ou vide.")
	private String email;
	
	@Size(min = 3)
	@NotEmpty(message = "Le nom ne peut pas être vide ou null")
	private String nom;
	
	@Size(min = 3)
	@NotEmpty(message = "Le prénom ne peut pas être vide ou null")
	private String prenoms;

	private String photoUrl;
	
	private Integer score = 0;
	
	@OneToMany(mappedBy = "participant")
	private List<Vote> votes;
	
	public Participant(){
		/**
		 * Constructeur par défaut
		 */
	}
	
	/**
	 * @param email
	 * @param nom
	 * @param prenoms
	 * @param photoUrl
	 */
	public Participant(String email, String nom, String prenoms, String photoUrl){
		this.email = email;
		this.nom = nom;
		this.prenoms = prenoms;
		this.photoUrl = photoUrl;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenoms
	 */
	public String getPrenoms() {
		return prenoms;
	}

	/**
	 * @param prenoms the prenoms to set
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * @return the votes
	 */
	public List<Vote> getVotes() {
		return votes;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

}
