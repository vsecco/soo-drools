package unesp.rc.creditloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unesp.rc.creditloan.domain.CreditLoan;

/**
 * Repositório JPA referente a limite de crédito
 */
public interface CreditLoanRepository extends JpaRepository<CreditLoan, Long> {
}
