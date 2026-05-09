package com.libbooks.library.controller;

import com.libbooks.library.model.dto.BookTransactionDTO;
import com.libbooks.library.model.entity.BookTransactionHistory;
import com.libbooks.library.service.interfaceService.BookTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookTransactionController {
    private final BookTransactionService bookTransactionService;
    public BookTransactionController(BookTransactionService bookTransactionService){
        this.bookTransactionService = bookTransactionService;
    }

    @GetMapping("/bookTransaction/{bookTransactionId}")
    public BookTransactionDTO getBookTransactionById(@PathVariable Integer bookTransactionId){
        return this.bookTransactionService.getBookTransactionById(bookTransactionId);
    }

    @GetMapping("/bookTransactions")
    public List<BookTransactionDTO> getAllBookTransactions(){
        return this.bookTransactionService.getBookTransactions();
    }

    @PostMapping("/bookTransaction")
    public void addBookTransaction(@RequestBody BookTransactionDTO bookTransaction){
        this.bookTransactionService.addBookTransaction(bookTransaction);
    }

    @PutMapping("/bookTransaction/{bookTransactionId}")
    public void updateBookTransaction(@PathVariable Integer bookTransactionId,@RequestBody BookTransactionDTO bookTransaction){
        this.bookTransactionService.updateBookTransaction(bookTransactionId,bookTransaction);
    }

    @DeleteMapping("/bookTransaction/{bookTransactionId}")
    public void deleteBookTransaction(@PathVariable Integer bookTransactionId){
        this.bookTransactionService.deleteBookTransaction(bookTransactionId);
    }
}
