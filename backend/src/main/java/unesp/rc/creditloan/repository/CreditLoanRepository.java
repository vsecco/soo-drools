package unesp.rc.creditloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unesp.rc.creditloan.domain.CreditLoan;

public interface CreditLoanRepository extends JpaRepository<CreditLoan, Long> {
}
