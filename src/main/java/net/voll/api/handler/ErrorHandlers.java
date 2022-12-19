package net.voll.api.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandlers {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> notFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<InvalidFields>> badRequestException(MethodArgumentNotValidException e) {
        var listFieldsWithErrors = e.getFieldErrors().stream().map(InvalidFields::new).toList();
        return ResponseEntity.badRequest().body(listFieldsWithErrors);
    }

    private record InvalidFields(String field, String message){
        public InvalidFields(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
