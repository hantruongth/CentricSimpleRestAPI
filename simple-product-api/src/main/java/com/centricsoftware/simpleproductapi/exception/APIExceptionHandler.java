package com.centricsoftware.simpleproductapi.exception;

import com.centricsoftware.simpleproductapi.dto.ErrorResponseDTO;
import com.centricsoftware.simpleproductapi.service.LanguageService;
import com.centricsoftware.simpleproductapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Locale;

/**
 * @author hantruong
 */
@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageService messageService;

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        FieldError fieldError = ex.getBindingResult().getFieldError();
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .status(status.toString())
                .message(String.format(fieldError.getDefaultMessage(), fieldError.getField()))
                .error(fieldError.getCode())
                .build();

        return ResponseEntity.badRequest().body(errorResponseDTO);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .message(ex.getLocalizedMessage())
                .error(ex.getCause().getLocalizedMessage())
                .build();

        return ResponseEntity.badRequest().body(errorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex, Locale locale) {
        String errorMessage = messageService.getMessage("unexpected.error", null);

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .message(errorMessage)
                .error(ex.getCause().getLocalizedMessage())
                .build();

        return ResponseEntity.internalServerError().body(errorResponseDTO);
    }

}
