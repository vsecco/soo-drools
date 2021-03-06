package unesp.rc.creditloan.controller.unsecured;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.service.UserService;

import javax.validation.Valid;

/**
 * Classe que contém os endpoints dos serviços públicos referentes a usuários
 */
@RestController
@RequestMapping("/public/user")
public class UserUnsecuredController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint que realiza a criação de um novo usuário
     * @param user
     */
    @RequestMapping(method = RequestMethod.POST, path = "/new")
    public void createUser(@RequestBody @Valid final User user) {
        this.userService.createUser(user);
    }

}
