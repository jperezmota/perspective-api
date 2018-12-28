package com.jonathanperez.perspective.emailmodule.services;

public interface EmailService {
	public void sendSimpleMessage(String to, String subject, String text);
}
