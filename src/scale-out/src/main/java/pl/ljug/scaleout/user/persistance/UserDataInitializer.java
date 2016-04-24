package pl.ljug.scaleout.user.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.ljug.scaleout.user.User;

import java.util.stream.Stream;

@Component
public class UserDataInitializer {

    @Autowired
    public UserDataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        Stream.of(
                User.builder().login("admin").passwordHash(passwordEncoder.encode("admin")).role("ADMIN").build()
                //User.builder().login("user").passwordHash(passwordEncoder.encode("user")).role("USER").build()
        ).forEach(userRepository::save);
    }

}
