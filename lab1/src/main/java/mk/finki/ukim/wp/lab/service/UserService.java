package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.User;
import mk.finki.ukim.wp.lab.model.enums.Role;

public interface UserService {

    User register(String username, String password, Role role);


    User findByUsername(String username);


}
