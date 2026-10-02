package com.libbooks.library.service.interfaceService;

import com.libbooks.library.enums.EmailTemplateName;
import jakarta.mail.MessagingException;
import jakarta.validation.constraints.Email;

public interface EmailService {

    public void sendEmail(String to, String username, EmailTemplateName emailTemplate , String confirmationUrl, String activationCode, String subject) throws MessagingException;
}
