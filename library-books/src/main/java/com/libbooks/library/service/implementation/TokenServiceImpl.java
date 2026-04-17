package com.libbooks.library.service.implementation;

import com.libbooks.library.model.entity.Token;
import com.libbooks.library.repository.TokenRepo;
import com.libbooks.library.service.interfaceService.TokenService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {
    private final TokenRepo tokenRepo;
    public TokenServiceImpl(TokenRepo tokenRepo){
        this.tokenRepo = tokenRepo;
    }

    @Override
    public Optional<Token> getTokenById(Integer tokenId){
        return this.tokenRepo.findById(tokenId);
    }

    @Override
    public  void addToken(Token token){
        this.tokenRepo.save(token);
    }

    @Override
    public void deleteToken(Integer tokenId){
        this.tokenRepo.deleteById(tokenId);
    }
}
