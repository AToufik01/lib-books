package com.libbooks.library.service.interfaceService;

import com.libbooks.library.auth.AuthenticationRequest;
import com.libbooks.library.auth.AuthenticationResponse;
import com.libbooks.library.auth.RegisterRequest;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

public interface AuthenticationService {
    void register(RegisterRequest request) throws MessagingException;

    AuthenticationResponse authenticate(@Valid AuthenticationRequest request);

    void activateAccount(String token) throws MessagingException;
}
