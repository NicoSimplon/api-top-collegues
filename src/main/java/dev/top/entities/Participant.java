package dev.top.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
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
	
	@Valid
	@OneToOne(mappedBy = "participant")
	private Classement classement;
	
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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the classement
	 */
	public Classement getClassement() {
		return classement;
	}

	/**
	 * @param classement the classement to set
	 */
	public void setClassement(Classement classement) {
		this.classement = classement;
	}

}
