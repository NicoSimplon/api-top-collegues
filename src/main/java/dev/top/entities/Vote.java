package dev.top.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

/**
 * Entité représentant un vote
 * 
 * @author Nicolas
 *
 */
@Entity
@Table(name = "votes")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Email
	private String emailDuCollegue;
	
	private LocalDate dateDuVote = LocalDate.now();
	
	private Boolean sensDuVote;
	
	@ManyToOne
	@JoinColumn(name = "votant_email")
	private Participant votant;
	
	public Vote(){
		/**
		 * Constructeur par défaut
		 */
	}
	
	public Vote(String emailDuCollegue, Boolean sensDuVote, Participant votant) {
		this.emailDuCollegue = emailDuCollegue;
		this.sensDuVote = sensDuVote;
		this.votant = votant;
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
	 * @return the emailDuCollegue
	 */
	public String getEmailDuCollegue() {
		return emailDuCollegue;
	}

	/**
	 * @param emailDuCollegue the emailDuCollegue to set
	 */
	public void setEmailDuCollegue(String emailDuCollegue) {
		this.emailDuCollegue = emailDuCollegue;
	}

	/**
	 * @return the dateDuVote
	 */
	public LocalDate getDateDuVote() {
		return dateDuVote;
	}

	/**
	 * @param dateDuVote the dateDuVote to set
	 */
	public void setDateDuVote(LocalDate dateDuVote) {
		this.dateDuVote = dateDuVote;
	}

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
	 * @return the votant
	 */
	public Participant getVotant() {
		return votant;
	}

	/**
	 * @param votant the votant to set
	 */
	public void setVotant(Participant votant) {
		this.votant = votant;
	}


}
