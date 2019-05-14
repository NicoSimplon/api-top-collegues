package dev.top.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String emailDuVotant;
	
	private String emailDuCollegue;
	
	private LocalDate dateDuVote = LocalDate.now();
	
	private Boolean sensDuVote;
	
	public Vote(){
		/**
		 * Constructeur par défaut
		 */
	}
	
	public Vote(String emailDuCollegue, Boolean sensDuVote, String emailDuVotant) {
		this.emailDuCollegue = emailDuCollegue;
		this.sensDuVote = sensDuVote;
		this.emailDuVotant = emailDuVotant;
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
	 * @return the emailDuVotant
	 */
	public String getEmailDuVotant() {
		return emailDuVotant;
	}

	/**
	 * @param emailDuVotant the emailDuVotant to set
	 */
	public void setEmailDuVotant(String emailDuVotant) {
		this.emailDuVotant = emailDuVotant;
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

}
