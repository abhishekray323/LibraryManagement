package com.example.LibraryManagement.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateBookRequest {

    @NotBlank(message = "Name of book should not be blank")
    String name;
    @NotBlank(message = "isbn should not be blanks")
    String isbn;

    @NotNull
    String authorName;
    @NotNull
    String authorEmail;
}
