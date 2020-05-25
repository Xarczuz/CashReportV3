package CashReport.repository;

import CashReport.model.views.UserAccountView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserAccountView, String> {
    Optional<UserAccountView> findByUsername(String userName);
}
