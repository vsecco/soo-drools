package unesp.rc.creditloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unesp.rc.creditloan.domain.Audit;
import unesp.rc.creditloan.domain.CreditLoan;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.service.CreditLoanService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/creditloan")
public class CreditLoanController {

    @Autowired
    private CreditLoanService creditLoanService;

    @RequestMapping(method = RequestMethod.POST, path = "/new")
    public void createCreditLoan() {
        this.creditLoanService.createCreditLoan();
    }
}
