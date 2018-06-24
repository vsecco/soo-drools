package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.Audit;
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
}
