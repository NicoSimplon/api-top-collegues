package dev.top.dto;

/**
 * Représente un vote pour un des participant
 * 
 * @author Nicolas
 *
 */
public class Vote {
	
	Boolean sensDuVote;
	
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
