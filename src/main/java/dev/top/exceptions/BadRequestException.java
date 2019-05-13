package dev.top.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -1323959732392640889L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BadRequestException.class);

	public BadRequestException() {

	}

	public BadRequestException(String msg) {
		LOGGER.error(msg);
	}
	
}
