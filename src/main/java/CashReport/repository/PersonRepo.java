package CashReport.repository;

import CashReport.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Integer> {
}
