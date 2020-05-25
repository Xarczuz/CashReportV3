package CashReport.repository;

import CashReport.model.tables.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String userName);
}
