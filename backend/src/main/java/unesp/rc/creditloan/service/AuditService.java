package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.Audit;
import unesp.rc.creditloan.domain.CreditLoan;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.repository.AuditRepository;

import java.util.List;

@Service
public class AuditService {

    @Autowired
    public AuditRepository auditRepository;

    @Autowired
    public UserService userService;

    public List<Audit> getAudit() {
        User loggedUser = userService.getLoggedUser();

        return this.auditRepository.findByUser(loggedUser);
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
