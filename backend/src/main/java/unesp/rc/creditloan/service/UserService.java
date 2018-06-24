
package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.CustomPrincipal;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.exception.BadRequestException;
import unesp.rc.creditloan.exception.ConflictException;
import unesp.rc.creditloan.exception.NotFoundException;
import unesp.rc.creditloan.repository.UserRepository;
import unesp.rc.creditloan.utils.StringEncoder;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        if(userRepository.findByCpf(user.getCpf()) == null) {
            user.setPassword(StringEncoder.encodeString(user.getPassword()));
            userRepository.save(user);
        } else {
            throw new ConflictException("Usuário já existente");
        }
    }

    public void updateUser(User user) {
        if(!this.getLoggedUser().getCpf().equals(user.getCpf())) {
            throw new BadRequestException("Não é permitido alterar o CPF");
        }

        User userDB = userRepository.findByCpf(user.getCpf());
        if(userDB != null) {
            user.setId(userDB.getId());
            user.setPassword(StringEncoder.encodeString(user.getPassword()));
            userRepository.save(user);
            this.setLoggedUser(user);
        } else {
            throw new NotFoundException("Usuário não encontrado");
        }
    }

    public User getDBUser(String cpf) {
        return userRepository.findByCpf(cpf);
    }


    /**
     * Recupera o usuário logado
     *
     * @return User
     */
    public User getLoggedUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((CustomPrincipal) principal).getUser();
    }

    /**
     * Altera o usuário logado na sessão
     * @param user
     */
    public void setLoggedUser(final User user) {
        final OAuth2Authentication auth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        final CustomPrincipal customPrincipal = (CustomPrincipal) auth.getPrincipal();
        customPrincipal.setUser(user);
    }

}
