package com.dhyancc.handson.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Cannot update ID", code = HttpStatus.UNPROCESSABLE_ENTITY)
public class IDUpdateException extends Exception {

	private static final long serialVersionUID = 1L;

}
