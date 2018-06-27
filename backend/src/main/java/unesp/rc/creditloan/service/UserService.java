
package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.CustomPrincipal;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.domain.request.UpdateUserRequest;
import unesp.rc.creditloan.exception.BadRequestException;
import unesp.rc.creditloan.exception.ConflictException;
import unesp.rc.creditloan.exception.NotFoundException;
import unesp.rc.creditloan.repository.UserRepository;
import unesp.rc.creditloan.utils.StringEncoder;

/**
 * Serviço que contém os métodos referente a usuário
 */
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

    public void updateUser(UpdateUserRequest user) {
        User loggedUser = this.getLoggedUser();

        User userDB = userRepository.findByCpf(loggedUser.getCpf());
        userDB.setCivilStatus(user.getCivilStatus());
        userDB.setAmountOfProperty(user.getAmountOfProperty());

        userRepository.save(userDB);
        this.setLoggedUser(userDB);
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
