package unesp.rc.creditloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unesp.rc.creditloan.domain.response.AuditResponse;
import unesp.rc.creditloan.service.AuditService;

/**
 * Classe que contém os endpoints dos serviços referentes a histórico de limite de crédito
 */
@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;

    /**
     * Endpoint que lista o histórico de limite de crédito do usuário logado
     * @return
     */
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public AuditResponse getAudit() {
        return this.auditService.getAudit();
    }
}