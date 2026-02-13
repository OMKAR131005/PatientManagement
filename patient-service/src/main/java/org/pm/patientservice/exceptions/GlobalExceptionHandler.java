package org.pm.patientservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException e){
        Map<String,String>err=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error->err.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(err);
    }
    @ExceptionHandler(EmailDuplicateException.class)
    public ResponseEntity<Map<String,String>>handleDuplicateEmail(EmailDuplicateException ex){
        Map<String,String>err=new HashMap<>();
        err.put("message", ex.getMessage());
        return ResponseEntity.ok().body(err);
    }

}
