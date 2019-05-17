package dev.top.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParticipantNotFound extends RuntimeException {

	private static final long serialVersionUID = 3461244740510874204L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantNotFound.class);

	public ParticipantNotFound() {
		LOGGER.error("Il n'y a aucun participant ayant cet email");
	}


}
