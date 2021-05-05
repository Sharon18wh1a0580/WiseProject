package com.rest1.dto;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;



import java.util.Properties;

public class SentemailTLS {
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
            
       } 
       
       catch (MessagingException e) {
    	   
    	   throw new RuntimeException(e);
       }
   }




	
}

