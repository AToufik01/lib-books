package com.libbooks.library.service.implementation;

import com.libbooks.library.model.entity.Book;
import com.libbooks.library.repository.BookRepo;
import com.libbooks.library.service.interfaceService.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@Transactional // roller back if error
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    @Override
    public Optional<Book> getBookById(Integer bookId){
        return this.bookRepo.findById(bookId);
    }

    @Override
    public List<Book> getBooks(){
        return this.bookRepo.findAll();
    }
    @Override
    public List<Book> getBooksByOwner(Integer ownerId) {
        return this.bookRepo.findByOwnerId(ownerId);
//        this function needed to get all book owned by user

    }
    @Override
    public void addBook(Book book){
        this.bookRepo.save(book);
    }
    @Override
    public void updateBook(Integer bookId,Book book){
        Book bookToUpdate = this.bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("Book not Found"));
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthorName(book.getAuthorName());
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setSynopsis(book.getSynopsis());
        bookToUpdate.setBookCover(book.getBookCover());
        bookToUpdate.setArchived(book.getArchived());
        bookToUpdate.setShareable(book.getShareable());
        this.bookRepo.save(bookToUpdate);
    }

    @Override
    public void deleteBook(Integer bookId){
        this.bookRepo.deleteById(bookId);
    }
}
