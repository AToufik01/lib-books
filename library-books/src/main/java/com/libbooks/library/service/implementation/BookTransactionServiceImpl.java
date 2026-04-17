package com.libbooks.library.service.implementation;

import com.libbooks.library.model.entity.BookTransactionHistory;
import com.libbooks.library.repository.BookTransactionRepo;
import com.libbooks.library.service.interfaceService.BookTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookTransactionServiceImpl implements BookTransactionService {
    private final BookTransactionRepo bookTransactionRepo;
    public BookTransactionServiceImpl(BookTransactionRepo bookTransactionRepo){
        this.bookTransactionRepo = bookTransactionRepo;
    }

    @Override
    public Optional<BookTransactionHistory> getBookTransactionById(Integer bookTransactionId){
        return this.bookTransactionRepo.findById(bookTransactionId);
    }
    @Override
    public List<BookTransactionHistory> getBookTransactions(){
        return this.bookTransactionRepo.findAll();
    }
    @Override
    public void addBookTransaction(BookTransactionHistory bookTransaction){
        this.bookTransactionRepo.save(bookTransaction);
    }
    @Override
    public void updateBookTransaction(Integer bookTransactionId,BookTransactionHistory bookTransaction){
        BookTransactionHistory transactionToUpdate = this.bookTransactionRepo.findById(bookTransactionId).orElseThrow(()->new RuntimeException("transaction book not Found"));
        transactionToUpdate.setReturned(bookTransaction.isReturned());
        transactionToUpdate.setReturnApproved(bookTransaction.isReturnApproved());
        this.bookTransactionRepo.save(transactionToUpdate);
    }

    @Override
    public  void deleteBookTransaction(Integer bookTransactionId){
        this.bookTransactionRepo.deleteById(bookTransactionId);
    }
}
