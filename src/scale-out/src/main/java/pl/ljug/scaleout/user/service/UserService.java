package pl.ljug.scaleout.user.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.ljug.scaleout.user.User;
import pl.ljug.scaleout.user.UserUpdateCommand;
import pl.ljug.scaleout.user.persistance.UserRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final @NonNull UserRepository userRepository;
    private final @NonNull PasswordEncoder passwordEncoder;

    public User update(UserUpdateCommand command) {
        User user = userRepository.findOne(command.getLogin());
        user = command.apply(user, passwordEncoder);
        return userRepository.save(user);
    }

}
