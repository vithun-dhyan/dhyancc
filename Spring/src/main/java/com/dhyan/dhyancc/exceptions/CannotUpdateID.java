package com.dhyan.dhyancc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Value;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Value()
@EqualsAndHashCode(callSuper = true)
public class CannotUpdateID extends Exception {
	private static final long serialVersionUID = 1L;
	private String msg;

}
