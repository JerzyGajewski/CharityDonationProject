package pl.coderslab.charity.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private UserRepository userRepository;
    private UserService userService;
    public LoginController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    String loginForm() {

        return "login";
    }

//    @PostMapping
//    String confirmLogin(@Param("email") String email){
//        userService.loadUserByUsername(email);
//        return "redirect:form";
//    }

}
