package com.example.LibraryManagement.service;

import com.example.LibraryManagement.exceptions.BookAlreadyExistException;
import com.example.LibraryManagement.exceptions.ExceptionCode;
import com.example.LibraryManagement.models.entity.Author;
import com.example.LibraryManagement.models.entity.Books;
import com.example.LibraryManagement.models.request.CreateBookRequest;
import com.example.LibraryManagement.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogueService {

    @Autowired
    AuthorService authorService;

    @Autowired
    BooksService booksService;

    public Books addBookToCatalogue(CreateBookRequest createBookRequest){
        var inMemoryBook = createBookRequest.toBook();
        Optional<Author> existingAuthor = authorService.getAuthorByemailId(inMemoryBook.getAssociatedAuthor().getEmailId());

        if(existingAuthor.isEmpty()){
            authorService.saveOrUpdate(inMemoryBook.getAssociatedAuthor());
        }

        Optional<Books> existingBooks = booksService.getBooksByIsbn(inMemoryBook.getIsbn());

        if(existingBooks.isPresent()){
            throw new BookAlreadyExistException(ExceptionCode.BOOK_ALREADY_EXISTS);
        }

        //MAKE Controller after this
        return booksService.saveOrUpdate(inMemoryBook);
    }

    public Books getBooks( String isbn){
        Optional<Books> existingBooks = booksService.getBooksByIsbn(isbn);

        if(existingBooks.isEmpty()){
            throw new BookAlreadyExistException(ExceptionCode.BOOK_NOT_FOUND);
        }
        return existingBooks.get();
    }

}
