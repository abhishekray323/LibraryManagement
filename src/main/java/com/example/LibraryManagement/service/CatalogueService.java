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

    Author checkIfAuthorExistOrNotAndAddAuthorIfNotExist(Books book){
        Optional<Author> existingAuthor = authorService.getAuthorByemailId(book.getAssociatedAuthor().getEmailId());
        return existingAuthor.orElseGet(() -> authorService.saveOrUpdate(book.getAssociatedAuthor())).get();
    }

    Books saveInMemoryBookAndIfNotExistThrowError(Books books) throws  BookAlreadyExistException{
        Optional<Books> existingBooks = booksService.getBooksByIsbn(books.getIsbn());
        if(existingBooks.isPresent()){
            throw new BookAlreadyExistException(ExceptionCode.BOOK_ALREADY_EXISTS);
        }
        return booksService.saveOrUpdate(books);
    }
    @Transactional
    public Books addBookToCatalogue(CreateBookRequest createBookRequest){
        // nice variable name "inMemoryBook"
        var inMemoryBook = createBookRequest.toBook();
        var author = checkIfAuthorExistOrNotAndAddAuthorIfNotExist(inMemoryBook);
        inMemoryBook.setAssociatedAuthor(author);

        Books savedBook;
        try {
            savedBook = saveInMemoryBookAndIfNotExistThrowError(inMemoryBook);
        } catch (BookAlreadyExistException e) {
            throw new RuntimeException(e);
        }
        return savedBook;
    }

    public Books getBooks( String isbn){
        Optional<Books> existingBooks = booksService.getBooksByIsbn(isbn);

        if(existingBooks.isEmpty()){
            throw new BookAlreadyExistException(ExceptionCode.BOOK_NOT_FOUND);
        }
        return existingBooks.get();
    }

}
