package com.example.demo.exception.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.shared.ErrorMessage;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value= {EntityNotFoundException.class})
	public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex){
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(), new Date(), 404);

		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= {EntityAlreadyExistsException.class})
	public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException ex){
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(), new Date(), 409);

		return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value= {MethodArgumentNotValidException.class})
	public ResponseEntity<Object> HandleMethodArgumentNotValid(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->
		errors.put(error.getField(),error.getDefaultMessage()));
		
		return new ResponseEntity<>(errors,new HttpHeaders(),HttpStatus.UNPROCESSABLE_ENTITY);
		
		
	}
	
}
