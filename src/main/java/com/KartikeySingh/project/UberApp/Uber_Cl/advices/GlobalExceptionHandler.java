package com.KartikeySingh.project.UberApp.Uber_Cl.advices;

import com.KartikeySingh.project.UberApp.Uber_Cl.exceptions.RuntimeConflictExceptions;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;
@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ConfigDataResourceNotFoundException exception) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(RuntimeConflictExceptions.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictExceptions exception) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.CONFLICT)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(MethodArgumentNotValidException exception) {
        List<String> errors = exception
                .getBindingResult() // BindingResult
                .getAllErrors() // List<ObjectError>
                .stream() // Stream<ObjectError>
                .map(error -> error.getDefaultMessage()) // Stream<String>
                .collect(Collectors.toList());

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input validation failed")
                .subErrors(errors)
                .build();
        return buildErrorResponseEntity(apiError);
    }
}
