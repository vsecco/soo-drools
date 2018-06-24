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

    public List<Audit> getAudit() {
        // TODO: pegar o logged user da memória
        User loggedUser = new User();

        return this.auditRepository.findByUser(loggedUser);
    }

    public void createAudit(CreditLoan creditLoan, User loggedUser) {
        // TODO: pegar o logged user da memória e remover do parametro do metodo

        Audit audit = new Audit();

        audit.setUser(loggedUser);
        audit.setCreditLoan(creditLoan);
        audit.setAmountOfProperty(loggedUser.getAmountOfProperty());
        audit.setCivilStatus(loggedUser.getCivilStatus());
        audit.setName(loggedUser.getName());

        this.auditRepository.save(audit);
    }
}
