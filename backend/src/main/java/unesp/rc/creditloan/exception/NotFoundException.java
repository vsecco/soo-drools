package unesp.rc.creditloan.exception;

import org.springframework.http.HttpStatus;

/**
 * Classe de exceção utilizado para "Recurso Não Encontrado"
 */
public class NotFoundException extends ServiceException {
    public NotFoundException(final String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}