package dev.top.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Représente un vote pour un des participant
 * 
 * @author Nicolas
 *
 */
public class Vote {
	
	@NotEmpty
	@Max(100000)
	@Min(-100000)
	Boolean sensDuVote;
	
	@Email
	@NotEmpty
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
