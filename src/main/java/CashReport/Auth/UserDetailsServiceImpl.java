package CashReport.Auth;

import CashReport.model.UserAccount;
import CashReport.repository.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println(userName);
        Optional<UserAccount> user = userRepo.findByUsername(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
        return toUserDetails(user.get());
    }

    private UserDetails toUserDetails(UserAccount userAccount) {
        return User.withUsername(userAccount.getUsername())
                .password(userAccount.getPassword())
                .roles(userAccount.getRole()).build();
    }
}
