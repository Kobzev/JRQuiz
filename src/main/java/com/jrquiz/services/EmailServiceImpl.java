package com.jrquiz.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jrquiz.domain.User;

public class EmailServiceImpl implements EmailService {

	private String username = "javarushmailrobot";
	private String password = "NthhfGf$$d5hl";
	private Properties props;

	@Override
	public boolean sendEmail(User user) {
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			// от кого
			message.setFrom(new InternetAddress(username));
			// кому
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			// Заголовок письма
			message.setSubject("registration");
			// Содержимое
			message.setText("To confirm registration you need go to http://localhost:8080/JRQuiz/confirm?id=" + user.getEmailtoken() + "  . Thanks!");

			// Отправляем сообщение
			Transport.send(message);
		} catch (MessagingException e) {
			// throw new RuntimeException(e);
			return false;
		}
		return true;
	}

}
