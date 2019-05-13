package dev.top.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Entité représentant le tableau de classement du jeu Top Collègues
 * Chaque participant est associé à un score qui détermine sa position 
 * dans le classement
 * 
 * @author Nicolas
 *
 */
@Entity
@Table(name = "classement")
public class Classement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Max(100000)
	@Min(-100000)
	private Integer score = 0;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "participant_id")
	private Participant participant;
	
	public Classement() {
		/**
		 * Constructeur pas défaut
		 */
	}

	public Classement(@Max(100000) @Min(-100000) Integer score, @Valid Participant participant) {
		this.score = score;
		this.participant = participant;
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
	 * @return the participant
	 */
	public Participant getParticipant() {
		return participant;
	}

	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}
