package de.sanvartis.demo.utils.exceptionHandler;

import de.sanvartis.demo.utils.exceptions.CustomRestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = {CustomRestException.class})
    protected ResponseEntity<Object> handleConflict(
            CustomRestException ex, WebRequest request) {
        return handleExceptionInternal(ex, new CustomRestExceptionWrapper(ex.getMessage(),ex.getStatus()),
                new HttpHeaders(), ex.getStatus(), request);
    }

    static class CustomRestExceptionWrapper {
        private String message;
        private HttpStatus status;
        private LocalDateTime timeStamp = LocalDateTime.now();

        public CustomRestExceptionWrapper(String message, HttpStatus status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public void setStatus(HttpStatus status) {
            this.status = status;
        }

        public LocalDateTime getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
        }
    }
}
