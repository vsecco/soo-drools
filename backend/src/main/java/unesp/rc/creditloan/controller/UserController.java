package unesp.rc.creditloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/new")
    public void createUser(@RequestBody @Valid final User user) {
        this.userService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update/{userId}")
    public void updateUser(@RequestBody @Valid final User user) {
        this.userService.updateUser(user);
    }
}
