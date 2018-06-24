package unesp.rc.creditloan.service;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.CreditLoan;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.domain.enums.CivilStatus;
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

    public void createCreditLoan() {
        // TODO: pegar usuário salvo na memória
        User loggedUser = new User();
        loggedUser.setId(1L);
        loggedUser.setName("name");
        loggedUser.setAmountOfProperty(1000);
        loggedUser.setCivilStatus(CivilStatus.MARRIED);
        loggedUser.setBirthdate(DateUtils.addYears(new Date(), -24));
        loggedUser.setCpf("456789567");

        try {
            ruleEngineService.fireAllRules(loggedUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CreditLoan creditLoan = new CreditLoan();
        creditLoan.setDate(new Date());
        creditLoan.setCreditLimit(loggedUser.getCreditLimit());
        creditLoan.setUser(loggedUser);
        this.creditLoanRepository.save(creditLoan);

        this.auditService.createAudit(creditLoan, loggedUser);
    }
}
