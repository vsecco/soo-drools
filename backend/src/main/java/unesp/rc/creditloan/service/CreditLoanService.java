package unesp.rc.creditloan.service;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.Audit;
import unesp.rc.creditloan.domain.CreditLoan;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.domain.enums.CivilStatus;
import unesp.rc.creditloan.repository.CreditLoanRepository;
import unesp.rc.creditloan.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CreditLoanService {

    @Autowired
    RuleEngineService ruleEngineService;

    @Autowired
    CreditLoanRepository creditLoanRepository;

    public void createCreditLoan() {
        // TODO: pegar usuário salvo na memória
        User loggedUser = new User();
        loggedUser.setAmountOfProperty(1000);
        loggedUser.setCivilStatus(CivilStatus.MARRIED);
        loggedUser.setBirthdate(DateUtils.addYears(new Date(), -24));
        loggedUser.setCpf("456789567");

        try {
            ruleEngineService.fireAllRules(loggedUser);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        CreditLoan creditLoan = new CreditLoan();
        creditLoan.setDate(new Date());
        creditLoan.setCreditLimit(loggedUser.getCreditLimit());
        creditLoan.setUser(loggedUser);
        this.creditLoanRepository.save(creditLoan);
    }
}
