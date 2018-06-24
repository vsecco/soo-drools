package unesp.rc.creditloan.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class AuditResponse {
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="America/Sao_Paulo")
    private Date birthdate;

    private String cpf;

    private List<CreditLoanResponse> creditLoanList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CreditLoanResponse> getCreditLoanList() {
        return creditLoanList;
    }

    public void setCreditLoanList( List<CreditLoanResponse> creditLoanList) {
        this.creditLoanList = creditLoanList;
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

    public AuditResponse(String name, Date birthdate, String cpf, List<CreditLoanResponse> creditLoanList) {
        this.name = name;
        this.birthdate = birthdate;
        this.cpf = cpf;
        this.creditLoanList = creditLoanList;
    }
}
