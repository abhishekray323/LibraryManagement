package com.example.LibraryManagement.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    String errorCode;
    String errorMessage;
}
