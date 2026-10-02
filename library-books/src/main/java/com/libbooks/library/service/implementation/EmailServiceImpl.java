package com.libbooks.library.service.implementation;

import com.libbooks.library.enums.EmailTemplateName;
import com.libbooks.library.service.interfaceService.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import org.thymeleaf.context.Context;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service

@Transactional // roller back if error
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;



    @Async
    public void sendEmail(String to, String username, EmailTemplateName emailTemplate , String confirmationUrl, String activationCode, String subject) throws MessagingException {
        String templateName =  emailTemplate.getName();
        MimeMessage  mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                true,
                StandardCharsets.UTF_8.name()
        );
        Map<String, Object> model = new HashMap<>();
        model.put("username", username);
        model.put("confirmationUrl", confirmationUrl);
        model.put("activationCode", activationCode);

        Context context = new Context();
        context.setVariables(model);

        String template = templateEngine.process(templateName, context);

        helper.setFrom("noreply@libbooks.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(template, true);
        javaMailSender.send(mimeMessage);

    }



}
