package com.libbooks.library.service.interfaceService;

import com.libbooks.library.model.entity.BookTransactionHistory;

import java.util.List;
import java.util.Optional;

public interface BookTransactionService {

    public Optional<BookTransactionHistory> getBookTransactionById(Integer bookTransactionId);
    public List<BookTransactionHistory> getBookTransactions();
    public void addBookTransaction(BookTransactionHistory bookTransaction);
    public void updateBookTransaction(Integer bookTransactionId,BookTransactionHistory bookTransaction);
    public  void deleteBookTransaction(Integer bookTransactionId);

}
