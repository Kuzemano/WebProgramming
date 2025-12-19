package mk.finki.ukim.wp.lab.web.controller;


import mk.finki.ukim.wp.lab.service.AuthService;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
@Controller
public class LoginController {

    public final AuthService authService;

    public LoginController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping
    public String login(){

        return "login";
    }

    @PostMapping
    public String realLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        authService.login(username, password);
        return "listBooks";

    }





}
