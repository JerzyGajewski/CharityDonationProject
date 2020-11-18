package pl.coderslab.charity.service.interfaces;

import pl.coderslab.charity.entity.User;

public interface UserInterface {

    User findByEmail(String email);
}
