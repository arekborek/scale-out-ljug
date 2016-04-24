package pl.ljug.scaleout.security;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.ljug.scaleout.staff.service.DoStaffService;
import pl.ljug.scaleout.user.persistance.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {

    private final @NonNull UserRepository userRepository;
    private final @NonNull DoStaffService doStaffService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        doStaffService.doStaff();
        return Optional.ofNullable(userRepository.findOne(s))
                .map(CurrentUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(s));
    }

}
