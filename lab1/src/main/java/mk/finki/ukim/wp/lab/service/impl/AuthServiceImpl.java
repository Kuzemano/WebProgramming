package mk.finki.ukim.wp.lab.service.impl;


import mk.finki.ukim.wp.lab.model.User;
import mk.finki.ukim.wp.lab.repository.UserRepository;
import mk.finki.ukim.wp.lab.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;


    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository =  userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User login(String username, String password) {
        System.out.println("wtf");
        User user = userRepository.findUserByUsername(username);
        System.out.println(user.getUsername());

        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("no good");
            throw new RuntimeException();
        }

        return user;
    }

}
