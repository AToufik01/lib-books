package com.libbooks.library.service.interfaceService;

import com.libbooks.library.model.dto.BookDTO;
import com.libbooks.library.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDTO getBookById(Integer bookId);
    List<BookDTO> getBooks();
    List<BookDTO> getBooksByOwner(Integer ownerId);
    BookDTO addBook(BookDTO book);
    BookDTO updateBook(Integer bookId,BookDTO book);
    void deleteBook(Integer bookId);

}
