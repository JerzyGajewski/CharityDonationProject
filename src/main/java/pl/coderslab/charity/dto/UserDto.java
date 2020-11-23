package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    String name;
    String surname;
    @NotEmpty
    String email;
    @NotEmpty
    String password1;
    @NotEmpty
    String password2;

}
