package dev.top.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ParticipantDTO {

	@Email(message = "L'email est invalide")
	@NotEmpty(message = "L'email est invalide")
	private String email;
	
	@NotEmpty(message = "Le nom est invalide")
	private String nom;
	
	@NotEmpty(message = "Le prénom est invalide")
	private String prenoms;
	
	@NotEmpty(message = "L'url de la photo est invalide")
	private String photoUrl;
	
	@NotEmpty(message = "Le score est invalide")
	private Integer score;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email
	 * @param nom
	 * @param prenoms
	 * @param photoUrl
	 * @param score
	 */
	public ParticipantDTO(@Email @NotEmpty String email, @NotEmpty String nom, @NotEmpty String prenoms,
			@NotEmpty String photoUrl, @NotEmpty Integer score) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenoms = prenoms;
		this.photoUrl = photoUrl;
		this.score = score;
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
	
}
