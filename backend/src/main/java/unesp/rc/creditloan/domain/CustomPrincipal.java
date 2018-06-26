package unesp.rc.creditloan.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Classe de customisação de Principal para armazenar o usuário logado na sessão
 */
public class CustomPrincipal extends User implements UserDetails {

    private static final long serialVersionUID = -6370945335191630476L;

    private unesp.rc.creditloan.domain.User user;

    public unesp.rc.creditloan.domain.User getUser() {
        return user;
    }

    public void setUser(unesp.rc.creditloan.domain.User user) {
        this.user = user;
    }

    public CustomPrincipal(final String username, final String password,
                           final Collection<? extends GrantedAuthority> authorities, final unesp.rc.creditloan.domain.User user) {
        super(username, password, authorities);
        this.user = user;
    }

}
