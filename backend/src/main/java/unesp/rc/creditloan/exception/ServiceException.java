package unesp.rc.creditloan.exception;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe de exceção utilizada para disparar exceções dos serviços
 */
public class ServiceException extends RuntimeException {


    public static final String GENERIC_MESSAGE = "Parâmetros obrigatórios não informados ou mesmo com formato inválido.";

    private final Map<String, String> messages = new HashMap<>();
    private final HttpStatus httpStatus;

    public ServiceException() {
        super(GENERIC_MESSAGE);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    /**
     * Construtor base da classe para definir mensagem e
     * código de status
     *
     * @param message
     * @param httpStatus
     */
    public ServiceException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    /**
     * Construtor da exceção que tem por padrão o código
     * de status BAD_REQUEST (400).
     *
     * @param message
     */
    public ServiceException(final String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    /**
     * Insere texto de validação ou erro na lista mensagens
     *
     * @param field
     * @param errorMsg
     * @return
     */
    public ServiceException addMsg(final String field, final String errorMsg) {
        this.messages.put(field, errorMsg);
        return this;
    }

    /**
     * Acessa a lista de mensagens
     *
     * @return
     */
    public Map<String, String> getMessages() {
        return this.messages;
    }

    /**
     * Código HTTP de status da exceção
     *
     * @return código de status
     */
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    /**
     * Retorna se há mensagens no objeto de exceção
     *
     * @return
     */
    public boolean hasMessages() {
        return !this.messages.isEmpty();
    }
}