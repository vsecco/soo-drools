package unesp.rc.creditloan.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.domain.enums.CivilStatus;

import java.util.Date;

@Service
public class CreditLoanService {

    public Double createCreditLoan() {
        User diane = new User();
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rule");

            FactHandle fact1;
            diane.setAmountOfProperty(150000);
            diane.setCivilStatus(CivilStatus.MARRIED);
            diane.setAge(24);
            diane.setCpf("456789567");

            fact1 = kSession.insert(diane);
            kSession.fireAllRules();


        } catch (Throwable t) {
            t.printStackTrace();
        }
        return diane.getCreditLimit();
    }
}
