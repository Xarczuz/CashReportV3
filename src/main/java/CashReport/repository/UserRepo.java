package CashReport.repository;

import CashReport.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserAccount, String> {
    Optional<UserAccount> findByUsername(String userName);
}
