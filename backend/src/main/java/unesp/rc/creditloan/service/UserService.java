
package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.exception.ConflictException;
import unesp.rc.creditloan.exception.NotFoundException;
import unesp.rc.creditloan.repository.UserRepository;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        if(userRepository.findByCpf(user.getCpf()) == null) {
            userRepository.save(user);
        } else {
            throw new ConflictException("Usuário já existente");
        }
    }

    public void updateUser(User user) {
        User userDB = userRepository.findByCpf(user.getCpf());
        if(userDB != null) {
            user.setId(userDB.getId());
            userRepository.save(user);
        } else {
            throw new NotFoundException("Usuário não encontrado");
        }
    }
}
