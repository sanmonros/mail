package com.sending.mail.services.impl;

import com.sending.mail.services.EmailServiceI;
import com.sending.mail.services.dto.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailServiceI{

    private final JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendMail(EmailDTO emailDTO) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(emailDTO.getAddressee());
            helper.setSubject(emailDTO.getIssue());

            Context context = new Context();
            context.setVariable("message", emailDTO.getMessage());
            String contentHtml = templateEngine.process("email", context);

            helper.setText(contentHtml, true);
            javaMailSender.send(message);
        } catch(Exception e){
            throw  new RuntimeException("Error al enviar el correo: "+ e.getMessage(),e);
        }
    }
}
