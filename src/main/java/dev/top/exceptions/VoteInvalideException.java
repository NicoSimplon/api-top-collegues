package dev.top.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoteInvalideException extends RuntimeException {

	private static final long serialVersionUID = 6571368779242569498L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantNotFound.class);
	
	static String message;

	public VoteInvalideException(String msg) {
		this.message = msg;
		LOGGER.error("VoteInvalideException : " + msg);
	}
	
}
