package unesp.rc.creditloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unesp.rc.creditloan.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
}
