package com.libbooks.library.service.interfaceService;


import com.libbooks.library.model.entity.Token;

import java.util.Optional;

public interface TokenService {

    public Optional<Token> getTokenById(Integer tokenId);
    public  void addToken(Token token);
    public void deleteToken(Integer tokenId);
}
