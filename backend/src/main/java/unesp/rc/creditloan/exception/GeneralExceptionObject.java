package unesp.rc.creditloan.exception;

import java.util.Set;

/**
 * Entidade para armazenar um objeto com os dados da exceção
 */
public class GeneralExceptionObject {

    private Integer status;
    private String error;
    private Set<String> messages;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Set<String> getMessages() {
        return messages;
    }

    public void setMessages(Set<String> messages) {
        this.messages = messages;
    }

    public GeneralExceptionObject(final Integer status, final String error, final Set<String> messages) {
        this.status = status;
        this.error = error;
        this.messages = messages;
    }
}
