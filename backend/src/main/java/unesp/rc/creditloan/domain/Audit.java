package unesp.rc.creditloan.domain;

import unesp.rc.creditloan.domain.enums.CivilStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private CreditLoan creditLoan;

    @NotNull
    @Column(length = 100)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private CivilStatus civilStatus;

    @NotNull
    private int amountOfProperty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getAmountOfProperty() {
        return amountOfProperty;
    }

    public void setAmountOfProperty(int amountOfProperty) {
        this.amountOfProperty = amountOfProperty;
    }
}
