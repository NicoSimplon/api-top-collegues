package dev.top.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = { ParticipantNotFound.class })
	protected ResponseEntity<Object> handleConflictParticipantNotFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Participant non trouvé";
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse);
	 }
	
	@ExceptionHandler(value = { BadRequestException.class })
	protected ResponseEntity<Object> handleConflictBadRequestException(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Les données du vote sont erronées";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyOfResponse);
	 }
	
	
	
}
