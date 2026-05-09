package com.libbooks.library.service.interfaceService;

import com.libbooks.library.model.dto.BookTransactionDTO;
import com.libbooks.library.model.entity.BookTransactionHistory;

import java.util.List;
import java.util.Optional;

public interface BookTransactionService {

    BookTransactionDTO getBookTransactionById(Integer bookTransactionId);
     List<BookTransactionDTO> getBookTransactions();
    BookTransactionDTO addBookTransaction(BookTransactionDTO bookTransaction);
    BookTransactionDTO updateBookTransaction(Integer bookTransactionId,BookTransactionDTO bookTransaction);
      void deleteBookTransaction(Integer bookTransactionId);

}
