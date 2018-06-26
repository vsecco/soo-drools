package unesp.rc.creditloan.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * Serviço que contém as configurações para disparar a execução das regras de negócio
 * referente a um objeto
 */
@Service
public class RuleEngineService {

    public void fireAllRules(Object object){

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rule");

        kSession.insert(object);
        kSession.fireAllRules();
    }
}
