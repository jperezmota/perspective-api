package com.jonathanperez.perspective.dto;

public class CustomErrorResponseDTO {
	public int status;
	public String message;
	public long timestamp;
	
	public CustomErrorResponseDTO(int status, String message, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}
}
