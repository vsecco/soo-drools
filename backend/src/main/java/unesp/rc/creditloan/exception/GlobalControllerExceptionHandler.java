package unesp.rc.creditloan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe que intercepta as exceções e configura a entidade de retorno dos serviços em caso de erro
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity defaultErrorHandler(final Exception e) {
        final Set<String> messages = new HashSet<>();
        messages.add(e.getMessage());


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GeneralExceptionObject(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), messages));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundException(final NotFoundException e) {
        final Set<String> messages = new HashSet<>();
        messages.add(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new GeneralExceptionObject(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(), messages));
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity conflictException(final ConflictException e) {
        final Set<String> messages = new HashSet<>();
        messages.add(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new GeneralExceptionObject(HttpStatus.CONFLICT.value(),
                        HttpStatus.CONFLICT.getReasonPhrase(), messages));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity badRequestException(final BadRequestException e) {
        final Set<String> messages = new HashSet<>();
        messages.add(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new GeneralExceptionObject(HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(), messages));
    }
}




