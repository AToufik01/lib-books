package com.libbooks.library.repository;

import com.libbooks.library.model.entity.Book;
import com.libbooks.library.model.entity.BookTransactionHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookTransactionRepo extends JpaRepository<BookTransactionHistory,Integer> {
//    @Query("SELECT b FROM BookTransactionHistory bth JOIN bth.book b")
//    List<Book> findAllBooksByUsers();
}
