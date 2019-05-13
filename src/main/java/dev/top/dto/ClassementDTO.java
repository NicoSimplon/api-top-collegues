package dev.top.dto;

/**
 * Répésente le score d'un participant
 * 
 * @author Nicolas
 *
 */
public class ClassementDTO {

	private Integer score;
	
	private String email;

	public ClassementDTO(){
		/**
		 * Constructeur par défaut
		 */
	}
	
	public ClassementDTO(Integer score, String email){
		this.score = score;
		this.email = email;
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
