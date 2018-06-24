package unesp.rc.creditloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unesp.rc.creditloan.domain.User;
import unesp.rc.creditloan.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
