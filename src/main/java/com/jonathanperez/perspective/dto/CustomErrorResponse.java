package com.jonathanperez.perspective.dto;

public class CustomErrorResponse {
	public int status;
	public String message;
	public long timestamp;
	
	public CustomErrorResponse(int status, String message, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}
}
