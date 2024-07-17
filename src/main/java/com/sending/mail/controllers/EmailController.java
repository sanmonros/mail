package com.sending.mail.controllers;

import com.sending.mail.services.EmailServiceI;
import com.sending.mail.services.dto.EmailDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailController {

    @Autowired
    EmailServiceI emailServiceI;

    @PostMapping("/send-email")
    private ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO) throws MessagingException {
        emailServiceI.sendMail(emailDTO);
        return new ResponseEntity<>("Correo" + "enviado exitosamente", HttpStatus.OK);
    }

}
