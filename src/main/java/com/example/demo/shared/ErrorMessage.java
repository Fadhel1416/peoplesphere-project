package com.example.demo.shared;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
public class ErrorMessage {
	
	String message;
	Date timestamp;
	Integer code;
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(String message, Date timestamp, Integer code) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public ErrorMessage build(){
		return new ErrorMessage();
	}

}
