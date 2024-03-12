package com.pp.exceptions;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstoreApplicationExceptions extends RuntimeException  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus httpStatus;
    private final List<String> errors;
    private final transient Object data;
    private final Integer cellulantStatusCode;
    

    public InstoreApplicationExceptions(String message) {
        this(HttpStatus.BAD_REQUEST, message);
    }

    public InstoreApplicationExceptions(HttpStatus httpStatus, String message) {
        this(httpStatus, message, Collections.singletonList(message), null, null);
    }

    public InstoreApplicationExceptions(HttpStatus httpStatus, String message, List<String> errors) {
        this(httpStatus, message, errors, null, null);
    }


    public InstoreApplicationExceptions(HttpStatus httpStatus, String message, List<String> errors, Integer cellulantStatusCode, Object data) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.data = data;
        this.cellulantStatusCode = cellulantStatusCode;
    }
    
}