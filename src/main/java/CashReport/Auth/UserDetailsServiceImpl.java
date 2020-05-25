package CashReport.Auth;

import CashReport.model.views.UserAccountView;
import CashReport.repository.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    public UserDetailsServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println(userName);
        Optional<UserAccountView> user = userRepo.findByUsername(userName);
        System.out.println("user Account View" + user.get());
        user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
        return toUserDetails(user.get());
    }


    private UserDetails toUserDetails(UserAccountView userAccountView) {
        return User.withUsername(userAccountView.getUsername())
                .password(passwordEncoder.encode(userAccountView.getPassword()))
                .roles(userAccountView.getRole()).build();
    }
}
