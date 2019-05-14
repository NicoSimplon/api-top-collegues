package dev.top.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Représente un vote pour un des participant
 * 
 * @author Nicolas
 *
 */
public class VoteDTO {
	
	Boolean sensDuVote;
	
	@Email(message = "L'email est invalide")
	@Size(min = 3, message = "L'email est invalide")
	@NotEmpty(message = "L'email est invalide")
	String email;

	/**
	 * @return the sensDuVote
	 */
	public Boolean getSensDuVote() {
		return sensDuVote;
	}

	/**
	 * @param sensDuVote the sensDuVote to set
	 */
	public void setSensDuVote(Boolean sensDuVote) {
		this.sensDuVote = sensDuVote;
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
	
}
