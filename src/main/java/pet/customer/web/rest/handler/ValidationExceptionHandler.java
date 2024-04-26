package pet.customer.web.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pet.customer.domain.dto.rest.enumeration.ErrorType;
import pet.customer.domain.dto.rest.error.CommonErrorResponse;
import pet.customer.domain.dto.rest.error.ValidationError;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ValidationExceptionHandler {
    private static final String MESSAGE_NOT_READABLE = "Message is not readable";

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableExceptionHandler(final HttpMessageNotReadableException exception) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body(CommonErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.I_AM_A_TEAPOT.value())
                        .type(ErrorType.SERVICE_ERROR)
                        .cause(MESSAGE_NOT_READABLE)
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(final MethodArgumentNotValidException exception) {
        List<ValidationError> errors = exception.getFieldErrors().stream()
                .map(error -> ValidationError.builder()
                        .field(error.getField())
                        .message(error.getDefaultMessage())
                        .build())
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(CommonErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .type(ErrorType.VALIDATION_ERROR)
                        .cause(errors)
                        .build());
    }
}
