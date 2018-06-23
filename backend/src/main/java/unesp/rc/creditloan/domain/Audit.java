package unesp.rc.creditloan.domain;

import unesp.rc.creditloan.domain.enums.CivilStatus;

public class Audit {
    private User user;
    private CreditLoan creditLoan;
    private String name;
    private CivilStatus civilStatus;
    private double amountOfProperty;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CreditLoan getCreditLoan() {
        return creditLoan;
    }

    public void setCreditLoan(CreditLoan creditLoan) {
        this.creditLoan = creditLoan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public double getAmountOfProperty() {
        return amountOfProperty;
    }

    public void setAmountOfProperty(double amountOfProperty) {
        this.amountOfProperty = amountOfProperty;
    }
}
