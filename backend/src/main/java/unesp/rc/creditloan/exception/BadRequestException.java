package unesp.rc.creditloan.exception;


import org.springframework.http.HttpStatus;

public class BadRequestException extends ServiceException {
    public BadRequestException(final String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}