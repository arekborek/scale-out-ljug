package pl.ljug.scaleout.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserUpdateCommand {

    private String login;
    private String password;

    public UserUpdateCommand forId(String login) {
        return new UserUpdateCommand(login, password);
    }

    public User apply(User user, PasswordEncoder passwordEncoder) {
        user.setPasswordHash(passwordEncoder.encode(password));
        return user;
    }
}
