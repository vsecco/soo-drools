package unesp.rc.creditloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unesp.rc.creditloan.service.CreditLoanService;

/**
 * Classe que contém os endpoints dos serviços referentes a limite de crédito
 */
@RestController
@RequestMapping("/creditloan")
public class CreditLoanController {

    @Autowired
    private CreditLoanService creditLoanService;

    /**
     * Endpoint que realiza a criação de uma nova solicitação de limite de crédito
     * para o usuário logado
     */
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.POST, path = "/new")
    public void createCreditLoan() {
        this.creditLoanService.createCreditLoan();
    }
}
