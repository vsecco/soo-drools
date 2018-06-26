package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.CreditLoan;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.repository.CreditLoanRepository;

import java.util.Date;

@Service
public class CreditLoanService {

    @Autowired
    RuleEngineService ruleEngineService;

    @Autowired
    AuditService auditService;

    @Autowired
    CreditLoanRepository creditLoanRepository;

    @Autowired
    UserService userService;

    public void createCreditLoan() {
        User loggedUser = userService.getLoggedUser();
        User dbUser = userService.getDBUser(loggedUser.getCpf());

        try {
            ruleEngineService.fireAllRules(dbUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CreditLoan creditLoan = new CreditLoan();
        creditLoan.setDate(new Date());
        creditLoan.setCreditLimit(dbUser.getCreditLimit());
        creditLoan.setUser(dbUser);
        this.creditLoanRepository.save(creditLoan);

        this.auditService.createAudit(creditLoan);
    }
}
