package CashReport.Auth;

import CashReport.model.Person;
import CashReport.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonRepo personRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Person> user = personRepo.findByUsername(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
        return toUserDetails(user.get());
    }

    private UserDetails toUserDetails(Person person) {
        return User.withUsername(person.getUsername())
                .password(person.getPassword())
                .roles(String.valueOf(person.getRoleid())).build();
    }
}
