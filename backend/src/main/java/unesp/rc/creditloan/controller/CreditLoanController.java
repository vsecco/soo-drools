package unesp.rc.creditloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unesp.rc.creditloan.service.CreditLoanService;

@RestController
@RequestMapping("/creditloan")
public class CreditLoanController {

    @Autowired
    private CreditLoanService creditLoanService;

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.POST, path = "/new")
    public void createCreditLoan() {
        this.creditLoanService.createCreditLoan();
    }
}
