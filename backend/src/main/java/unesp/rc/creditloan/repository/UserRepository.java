package unesp.rc.creditloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unesp.rc.creditloan.domain.User;

/**
 * Repositório JPA referente a usuário
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
}
