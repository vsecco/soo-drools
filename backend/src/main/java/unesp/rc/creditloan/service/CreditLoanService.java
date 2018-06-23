package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.domain.enums.CivilStatus;

@Service
public class CreditLoanService {

    @Autowired
    RuleEngineService ruleEngineService;

    public Double createCreditLoan() {
        User diane = new User();
        diane.setAmountOfProperty(1000);
        diane.setCivilStatus(CivilStatus.MARRIED);
        diane.setAge(24);
        diane.setCpf("456789567");

        try {
            ruleEngineService.fireAllRules(diane);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return diane.getCreditLimit();
    }
}
