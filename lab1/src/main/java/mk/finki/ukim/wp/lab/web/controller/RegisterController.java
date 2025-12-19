package mk.finki.ukim.wp.lab.web.controller;


import mk.finki.ukim.wp.lab.model.enums.Role;
import mk.finki.ukim.wp.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    public final UserService userService;

    public RegisterController(UserService userService){
        this.userService = userService;
    }





    @GetMapping
    public String register(Model model){
        List<String> roles = new ArrayList<>(List.of(
                "ROLE_USER",
                "ROLE_ADMIN"
        )) ;
        model.addAttribute("roles", roles);
        return "register";


    }

    @PostMapping
    public String realRegiser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role){




        if(role.equals("ROLE_USER")){
            userService.register(username, password, Role.ROLE_USER);
        }

        else if(role.equals("ROLE_ADMIN")){

            userService.register(username, password, Role.ROLE_ADMIN);
        }
        return "redirect:/books";


    }








}
