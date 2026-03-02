package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.services.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderServiceImpl implements EmailSenderService {
//हां, JavaMailSender और SimpleMailMessage Spring Boot में built-in hote h
//    private final JavaMailSenderImpl javaMailSender;//JavaMailSender एक इंटरफेस (नियमों का सेट) है जो Spring Boot में email भेजने के लिए use hota h.
    @Override
    public void sendEmail(String toEmail, String subject, String body) {
       try{
           SimpleMailMessage simpleMailMessage = new SimpleMailMessage();//Email भेजना बहुत आसान हो जाता है Gmail, Yahoo जैसे किसी भी SMTP server से connect कर सकते हैं

           simpleMailMessage.setTo(toEmail);
           simpleMailMessage.setSubject(subject);
           simpleMailMessage.setText(body);
//           javaMailSender.send(simpleMailMessage);
           log.info("Email sent successfully");
       }
       catch (Exception e)
       {
           log.info("cannot send email"+e.getMessage());
       }

    }

    @Override// ye wala mutiple email at once send k liye h kyuki yha array use
    public void sendEmail(String[] toEmail, String subject, String body) {
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setTo("kartikeymvs2017@gmail.com");
            simpleMailMessage.setBcc(toEmail);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(body);

//            javaMailSender.send(simpleMailMessage);
            log.info("Email sent successfully");
        }
        catch (Exception e)
        {
            log.info("cannot send email"+e.getMessage());
        }
    }
}
