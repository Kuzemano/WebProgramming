package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.User;
import mk.finki.ukim.wp.lab.model.enums.Role;
import mk.finki.ukim.wp.lab.repository.UserRepository;
import mk.finki.ukim.wp.lab.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(String username, String password, Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        userRepository.save(user);
        return userRepository.findUserByUsername(username);

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
