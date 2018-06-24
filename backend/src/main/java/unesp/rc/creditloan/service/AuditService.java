package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.Audit;
import unesp.rc.creditloan.domain.CreditLoan;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.domain.response.AuditResponse;
import unesp.rc.creditloan.domain.response.CreditLoanResponse;
import unesp.rc.creditloan.repository.AuditRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class AuditService {

    @Autowired
    public AuditRepository auditRepository;

    @Autowired
    public UserService userService;

    public AuditResponse getAudit() {
        User loggedUser = userService.getLoggedUser();

        List<Audit> listAudit = this.auditRepository.findByUser(loggedUser);

        AuditResponse auditResponse = new AuditResponse(loggedUser.getName(), loggedUser.getBirthdate(),
                loggedUser.getCpf(), new ArrayList<>());

        for (Audit audit : listAudit) {
            CreditLoanResponse creditLoanResponse = new CreditLoanResponse(audit.getCreditLoan().getId(),
                    audit.getCreditLoan().getDate(), audit.getCreditLoan().getCreditLimit(), audit.getCivilStatus(),
                    audit.getAmountOfProperty());

            auditResponse.getCreditLoanList().add(creditLoanResponse);
        }

        auditResponse.getCreditLoanList().sort(Comparator.comparing(CreditLoanResponse::getId).reversed());
        return auditResponse;
    }

    public void createAudit(CreditLoan creditLoan) {
        User loggedUser = userService.getLoggedUser();

        Audit audit = new Audit();

        audit.setUser(loggedUser);
        audit.setCreditLoan(creditLoan);
        audit.setAmountOfProperty(loggedUser.getAmountOfProperty());
        audit.setCivilStatus(loggedUser.getCivilStatus());
        audit.setName(loggedUser.getName());

        this.auditRepository.save(audit);
    }
}
