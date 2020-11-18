package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    String registerConfirm(@Valid @ModelAttribute("user") User user){
    if(!user.getPassword1().equals(user.getPassword2())){
        return "/register";
    } else {
        userRepository.save(user);
        return "login";
    }

    }
}
