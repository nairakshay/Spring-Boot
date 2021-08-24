package com.akshay.Springboot.tutorial.error;

import com.akshay.Springboot.tutorial.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice//Because we are handling exception in this class
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    //We need to add response entity so that it can be sent back
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception,
                                                                   WebRequest request){

          ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
