package unesp.rc.creditloan.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import unesp.rc.creditloan.domain.enums.CivilStatus;

import java.util.Date;

public class CreditLoanResponse {
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="America/Sao_Paulo")
    private Date date;

    private double creditLimit;

    private CivilStatus civilStatus;

    private int amountOfProperty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

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

    public CreditLoanResponse(Long id, Date date, double creditLimit, CivilStatus civilStatus, int amountOfProperty) {
        this.id = id;
        this.date = date;
        this.creditLimit = creditLimit;
        this.civilStatus = civilStatus;
        this.amountOfProperty = amountOfProperty;
    }
}
