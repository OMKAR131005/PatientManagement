package org.pm.patientservice.exceptions;

public class EmailDuplicateException extends  RuntimeException{
   public EmailDuplicateException(String ex){
        super(ex);
    }
}
