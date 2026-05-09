package com.libbooks.library.service.implementation;

import com.libbooks.library.model.dto.BookTransactionDTO;
import com.libbooks.library.model.entity.BookTransactionHistory;
import com.libbooks.library.repository.BookTransactionRepo;
import com.libbooks.library.service.interfaceService.BookTransactionService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookTransactionServiceImpl implements BookTransactionService {
    private final BookTransactionRepo bookTransactionRepo;
    private final ModelMapper modelMapper;
    public BookTransactionServiceImpl(BookTransactionRepo bookTransactionRepo , ModelMapper modelMapper){
        this.bookTransactionRepo = bookTransactionRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookTransactionDTO getBookTransactionById(Integer bookTransactionId){
        try {
            BookTransactionHistory bookTransaction = this.bookTransactionRepo.findById(bookTransactionId).orElseThrow(() -> new RuntimeException("transaction book not Found"));
            return this.modelMapper.map(bookTransaction, BookTransactionDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public List<BookTransactionDTO> getBookTransactions(){
        try{
            return this.bookTransactionRepo.findAll().stream().map(bookTransaction -> this.modelMapper.map(bookTransaction, BookTransactionDTO.class)).collect(Collectors.toList());
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public BookTransactionDTO addBookTransaction(BookTransactionDTO bookTransaction){
        try{
            BookTransactionHistory bookTransactionToAdd = this.modelMapper.map(bookTransaction,BookTransactionHistory.class);
            bookTransactionToAdd = this.bookTransactionRepo.save(bookTransactionToAdd);
            return this.modelMapper.map(bookTransactionToAdd,BookTransactionDTO.class);
        }
        catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public BookTransactionDTO updateBookTransaction(Integer bookTransactionId,BookTransactionDTO bookTransaction){

        try{
            BookTransactionHistory bookTransactionToUpdate = this.bookTransactionRepo.findById(bookTransactionId).orElseThrow(()-> new RuntimeException("transaction book not Found"));
            this.modelMapper.map(bookTransaction,bookTransactionToUpdate);
            bookTransactionToUpdate.setId(bookTransactionId);
            bookTransactionToUpdate = this.bookTransactionRepo.save(bookTransactionToUpdate);
            return this.modelMapper.map(bookTransactionToUpdate,BookTransactionDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public  void deleteBookTransaction(Integer bookTransactionId){
        try{
            this.bookTransactionRepo.findById(bookTransactionId).orElseThrow(() -> new RuntimeException("transaction book not Found"));
            this.bookTransactionRepo.deleteById(bookTransactionId);

        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
