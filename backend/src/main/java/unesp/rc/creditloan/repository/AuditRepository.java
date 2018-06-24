package unesp.rc.creditloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unesp.rc.creditloan.domain.Audit;
import unesp.rc.creditloan.domain.User;

import java.util.List;

public interface AuditRepository extends JpaRepository<Audit, Long> {

    List<Audit> findByUser(User user);
}
