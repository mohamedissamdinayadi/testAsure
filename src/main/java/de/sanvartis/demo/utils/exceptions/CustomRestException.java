package de.sanvartis.demo.utils.exceptions;

import org.springframework.http.HttpStatus;

public class CustomRestException extends RuntimeException {

    private HttpStatus status;

    public CustomRestException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
