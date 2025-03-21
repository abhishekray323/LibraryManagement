package com.example.LibraryManagement.models.request;

import com.example.LibraryManagement.models.entity.Author;
import com.example.LibraryManagement.models.entity.Books;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookRequest {

    @NotBlank(message = "Name of book should not be blank")
    String name;
    @NotBlank(message = "isbn should not be blanks")
    String isbn;

    @NotNull
    String authorName;
    @NotNull
    String authorEmail;

    public Books toBook(){
        var associatedAuthor =  Author.builder()
                .name(authorName)
                .emailId(authorEmail)
                        .build();

        return Books.builder()
                .name(name)
                .isbn(isbn)
                .associatedAuthor(associatedAuthor)
                .build();
    }
}
