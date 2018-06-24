package unesp.rc.creditloan.service;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.Audit;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.domain.enums.CivilStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CreditLoanService {

    @Autowired
    RuleEngineService ruleEngineService;

    public Double createCreditLoan() {
        // TODO: pegar usuário salvo na memória
        User user = new User();
        user.setAmountOfProperty(1000);
        user.setCivilStatus(CivilStatus.MARRIED);
        user.setBirthdate(DateUtils.addYears(new Date(), -24));
        user.setCpf("456789567");

        try {
            ruleEngineService.fireAllRules(user);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return user.getCreditLimit();
    }

    public List<Audit> getAudit(int userId) {
        // TODO: pegar lista de audit do jeito do DAO da Lari
        return new ArrayList<Audit>();
    }
}
