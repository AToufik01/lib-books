package com.libbooks.library.controller;

import com.libbooks.library.model.dto.BookDTO;
import com.libbooks.library.model.entity.Book;
import com.libbooks.library.service.interfaceService.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/book/{bookId}")
    public BookDTO getBookById(@PathVariable Integer bookId){
        return this.bookService.getBookById(bookId);
    }
    @GetMapping("/books")
    public List<BookDTO> getAllBooks(){
        return this.bookService.getBooks();
    }
//
    @GetMapping("/books/owner/{ownerId}")
    public List<BookDTO> getBooksByOwner(@PathVariable Integer ownerId){
        return this.bookService.getBooksByOwner(ownerId);
    }
    @PostMapping("/book")
    public void addBook(@RequestBody BookDTO book){
       BookDTO bookDTO = this.bookService.addBook(book);
    }
    @PostMapping("/book/{bookId}")
    public void updateBook( @PathVariable Integer bookId, @RequestBody BookDTO book){
        BookDTO bookDTO = this.bookService.updateBook(bookId,book);
    }
    @DeleteMapping("/book/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.bookService.deleteBook(bookId);
    }

}
