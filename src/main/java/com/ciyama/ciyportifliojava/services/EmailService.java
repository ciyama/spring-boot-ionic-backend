package com.ciyama.ciyportifliojava.services;

import org.springframework.mail.SimpleMailMessage;

import com.ciyama.ciyportifliojava.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
