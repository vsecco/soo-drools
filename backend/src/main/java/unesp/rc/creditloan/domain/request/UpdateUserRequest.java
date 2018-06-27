package unesp.rc.creditloan.domain.request;

import unesp.rc.creditloan.domain.enums.CivilStatus;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Entidade UpdateUserRequest para armazenar os dados de usuário na requisição do serviço
 */
public class UpdateUserRequest {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private CivilStatus civilStatus;

    @NotNull
    private int amountOfProperty;

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public int getAmountOfProperty() {
        return amountOfProperty;
    }

    public void setAmountOfProperty(int amountOfProperty) {
        this.amountOfProperty = amountOfProperty;
    }
}
