package com.cognizant.truyum.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.truyum.model.CustomErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {

	@ExceptionHandler({UserException.class})
	public ResponseEntity<CustomErrorResponse> handleProductException(UserException ex){
		CustomErrorResponse response=new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Inavalid Product id Provided");
		response.setMessage(ex.getMessage());
		
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({MenuItemException.class})
	public ResponseEntity<CustomErrorResponse> handleException(MenuItemException ex){
		CustomErrorResponse response=new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Inavalid information");
		response.setMessage(ex.getMessage());
		
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({CartItemException.class})
	public ResponseEntity<CustomErrorResponse> handleException(CartItemException ex){
		CustomErrorResponse response=new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Inavalid information");
		response.setMessage(ex.getMessage());
		
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<CustomErrorResponse> handleException(Exception ex){
		CustomErrorResponse response=new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Inavalid information");
		response.setMessage(ex.getMessage());
		
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
}
