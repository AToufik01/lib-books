package com.libbooks.library.service.interfaceService;

import com.libbooks.library.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Optional<Book> getBookById(Integer bookId);
    public List<Book> getBooks();
    public List<Book> getBooksByOwner(Integer ownerId);
    public void addBook(Book book);
    public void updateBook(Integer bookId,Book book);
    public void deleteBook(Integer bookId);

}
