package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.CreditLoan;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.repository.CreditLoanRepository;

import java.util.Date;

/**
 * Serviço que contém os métodos referente a limite de crédito
 */
@Service
public class CreditLoanService {

    @Autowired
    private RuleEngineService ruleEngineService;

    @Autowired
    private AuditService auditService;

    @Autowired
    private CreditLoanRepository creditLoanRepository;

    @Autowired
    private UserService userService;

    /**
     * Método que realiza a criação de uma solicitação de limite de crédito
     * Utiliza os dados do usuário logado para disparar as regras de negócio
     */
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
