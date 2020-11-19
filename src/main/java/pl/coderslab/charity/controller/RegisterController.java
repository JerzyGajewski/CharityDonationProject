package pl.coderslab.charity.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/register")
    String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registerConfirm")
    String registerConfirm(@Valid @ModelAttribute("user") User user, @Param("password1") String password1,
                           @Param("password2") String password2) {
        if (!password1.equals(password2)) {
            return "register";
        } else {
            user.setPassword(password1);
            userRepository.save(user);
            return "login";
        }

    }
}
