package com.jonathanperez.perspective.restmodule.dtos;

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
