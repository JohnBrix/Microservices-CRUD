package com.example.observable_crud_demo.exception;

import com.example.observable_crud_demo.util.UriUtil;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

    private final MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleInternalServer(Exception exception) {
        List<Message> messages = Arrays.asList(new Message(exception.getMessage()));
        return new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(), messages, UriUtil.path());
    }
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleHttpClientErrorException(Exception exception) {
        List<Message> messages = Arrays.asList(new Message(exception.getMessage()));
        return new ApiErrorResponse(HttpStatus.NOT_FOUND, LocalDateTime.now(), messages, UriUtil.path());
    }
   /* @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleNullException(Exception exception) {
        List<Message> messages = Arrays.asList(new Message(exception.getMessage()));
        return new ApiErrorResponse(HttpStatus.NO_CONTENT, LocalDateTime.now(), messages, UriUtil.path());
    }*/



}
