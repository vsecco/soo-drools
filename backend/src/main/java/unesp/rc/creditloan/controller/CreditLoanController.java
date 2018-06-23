package unesp.rc.creditloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unesp.rc.creditloan.domain.Audit;
import unesp.rc.creditloan.service.CreditLoanService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/creditloan")
public class CreditLoanController {

    @Autowired
    private CreditLoanService creditLoanService;

    @RequestMapping(method = RequestMethod.POST, path = "/new")
    public Double createCreditLoan() {
        return this.creditLoanService.createCreditLoan();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/audit/{userId}")
    public List<Audit> getAudit(@RequestParam @Valid final int userId) {
        return this.creditLoanService.getAudit(userId);
    }
}
