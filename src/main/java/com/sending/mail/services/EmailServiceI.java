package com.sending.mail.services;

import com.sending.mail.services.dto.EmailDTO;
import jakarta.mail.MessagingException;

public interface EmailServiceI {

    public void sendMail(EmailDTO emailDTO) throws MessagingException;
}
