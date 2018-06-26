package unesp.rc.creditloan.exception;

import org.springframework.http.HttpStatus;

/**
 * Classe de exceção do tipo Conflito
 */
public class ConflictException extends ServiceException {
    public ConflictException(final String message) {
        super(message, HttpStatus.CONFLICT);
    }
}