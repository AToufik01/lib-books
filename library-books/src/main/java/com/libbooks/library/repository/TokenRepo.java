package com.libbooks.library.repository;

import com.libbooks.library.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<Token,Integer> {
}
