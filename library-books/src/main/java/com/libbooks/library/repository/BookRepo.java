package com.libbooks.library.repository;

import com.libbooks.library.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> findByOwnerId(Integer ownerId);
}
