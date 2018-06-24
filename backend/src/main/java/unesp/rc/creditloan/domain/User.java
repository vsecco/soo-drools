package unesp.rc.creditloan.domain;

import unesp.rc.creditloan.domain.enums.CivilStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthdate;
    private String cpf;
    private String password;
    private CivilStatus civilStatus;
    private int amountOfProperty;
    private double creditLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getAge() {
        Calendar today = Calendar.getInstance();
        Calendar dayOfBirth = Calendar.getInstance();
        dayOfBirth.setTime(this.birthdate);

        return today.get(Calendar.YEAR) - dayOfBirth.get(Calendar.YEAR);
    }
}
