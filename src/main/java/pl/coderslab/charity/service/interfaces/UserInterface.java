package pl.coderslab.charity.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.charity.entity.User;

public interface UserInterface extends UserDetailsService {

    User findByEmail(String email);
}
