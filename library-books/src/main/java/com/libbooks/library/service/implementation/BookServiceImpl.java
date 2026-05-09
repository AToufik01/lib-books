package com.libbooks.library.service.implementation;

import com.libbooks.library.model.dto.BookDTO;
import com.libbooks.library.model.entity.Book;
import com.libbooks.library.repository.BookRepo;
import com.libbooks.library.service.interfaceService.BookService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

@Transactional // roller back if error
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepo bookRepo , ModelMapper modelMapper){
        this.bookRepo = bookRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO getBookById(Integer bookId){

        try {
            Book book = this.bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("Book not Found"));
            return this.modelMapper.map(book,BookDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<BookDTO> getBooks(){
        try{
            return this.bookRepo.findAll().stream().map(book -> this.modelMapper.map(book ,BookDTO.class)).collect(Collectors.toList());
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public List<BookDTO> getBooksByOwner(Integer ownerId) {
      //  return this.bookRepo.findByOwnerId(ownerId);
//        this function needed to get all book owned by user
        return null;
    }
    @Override
    public BookDTO addBook(BookDTO book){
        try{
            Book bookToAdd = this.modelMapper.map(book,Book.class);
            bookToAdd = this.bookRepo.save(bookToAdd);
            return this.modelMapper.map(bookToAdd,BookDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public BookDTO updateBook(Integer bookId,BookDTO book){
        try{
        Book bookToUpdate = this.bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("Book not Found"));
         modelMapper.map(book,bookToUpdate);
         bookToUpdate.setId(bookId);
         bookToUpdate = this.bookRepo.save(bookToUpdate);
         return this.modelMapper.map(bookToUpdate,BookDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteBook(Integer bookId){
        try {
            Book book = this.bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("Book not Found"));
            this.bookRepo.deleteById(bookId);
        }catch (Exception e) {
            throw new RuntimeException("Failed to delete user with ID " + bookId);
        }
    }
}
