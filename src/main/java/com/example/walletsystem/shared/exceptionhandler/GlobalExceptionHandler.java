package com.example.walletsystem.shared.exceptionhandler;

import com.example.walletsystem.asset.application.exception.InvalidAssetPriceException;
import com.example.walletsystem.user.application.exception.UserAlreadyExistException;
import com.example.walletsystem.user.infrastructure.exception.UserNotFoundException;
import com.example.walletsystem.shared.response.ApiError;
import com.example.walletsystem.wallet.application.exception.WalletNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(UserNotFoundException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(404, ex.getMessage()));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExist(UserAlreadyExistException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiError.of(409, ex.getMessage()));
    }

    @ExceptionHandler(InvalidAssetPriceException.class)
    public ResponseEntity<ApiError> handleInvalidAssetPrice(InvalidAssetPriceException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of(400, ex.getMessage()));
    }

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<ApiError> handleWalletNotFound(WalletNotFoundException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(404, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errorMessage.append(error.getField().toUpperCase(Locale.ROOT))
                        .append(": ")
                        .append(error.getDefaultMessage())
                        .append("; "));

        // Remove the trailing semicolon and space if there are errors
        if (!errorMessage.isEmpty()) {
            errorMessage.delete(errorMessage.length() - 2, errorMessage.length());
        } else {
            errorMessage.append("Validation failed");
        }
        log.error(ex.getMessage());
        ApiError apiError = ApiError.of(HttpStatus.BAD_REQUEST.value(), errorMessage.toString());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
