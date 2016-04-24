package pl.ljug.scaleout.user.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ljug.scaleout.user.User;

public interface UserRepository extends JpaRepository<User, String> {
}
