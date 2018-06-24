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

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

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
