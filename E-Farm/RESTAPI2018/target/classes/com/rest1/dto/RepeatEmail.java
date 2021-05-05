package com.rest1.dto;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RepeatEmail {
	public void efarm(Customer customer){

		System.out.println("In mail sending");

		        final String username = "farmdel9@gmail.com";
		        final String password = "BVRIThyderabad";
		       
		       String sendMessage="Your order is confirmed !!! :) Thank you for your order from E-FARM";
		       
		       Properties prop = new Properties();
		       prop.put("mail.smtp.host", "smtp.gmail.com");
		       prop.put("mail.smtp.port", "587");
		       prop.put("mail.smtp.auth", "true");
		       prop.put("mail.smtp.starttls.enable", "true"); //TLS

		       Session session = Session.getInstance(prop,
		               new javax.mail.Authenticator() {
		                   protected PasswordAuthentication getPasswordAuthentication() {
		                       return new PasswordAuthentication(username, password);
		                   }
		               });

		       try {

		           Message message = new MimeMessage(session);
		           message.setFrom(new InternetAddress("farmdel9@gmail.com"));
		           message.setRecipients(
		                   Message.RecipientType.TO,
		                   InternetAddress.parse(customer.getEmail())
		           );
		           message.setSubject("Confirmation mail ");
		           message.setText(sendMessage);

		           Transport.send(message);

		           System.out.println("Done");
		           
		           try{
		            	 Thread.sleep(60000);
		            	 Message message1 = new MimeMessage(session);
		                 message1.setFrom(new InternetAddress("farmdel9@gmail.com"));
		                 message1.setRecipients(
		                         Message.RecipientType.TO,
		                         InternetAddress.parse(customer.getEmail())
		                 );
		                 message1.setSubject("Confirmation mail ");
		                 message1.setText(sendMessage);

		                 Transport.send(message1);

		                 System.out.println("Done");
		            	 
		            	 
		            	 
		            	 
		             }catch (Exception e) {
		          	   
		          	   System.out.println(e);
		             }

		       } 
		       
		       catch (MessagingException e) {
		    	   
		    	   throw new RuntimeException(e);
		       }
		   }




			
		}


	