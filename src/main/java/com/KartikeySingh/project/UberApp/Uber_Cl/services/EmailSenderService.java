package com.KartikeySingh.project.UberApp.Uber_Cl.services;

public interface EmailSenderService {
     void sendEmail(String toEmail, String Subject, String body);
     void sendEmail(String toEmail[],String Subject,String body);
}
