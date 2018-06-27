package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.CustomPrincipal;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.repository.UserRepository;

/**
 * Serviço que implementa a interface UserDetailsService do Spring Security
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Método que realiza a busca de um usuário no repositório e retorna um objeto Principal
     * preenchido com CPF, senha, perfil e objeto User
     * @param username CPF
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userRepository.findByCpf(username);

        if (user != null) {
            return new CustomPrincipal(user.getCpf(), user.getPassword(),
                    AuthorityUtils.createAuthorityList("ROLE_USER"), user);
        } else {
            throw new UsernameNotFoundException("Cpf '" + username + "' not found.");
        }
    }

}
