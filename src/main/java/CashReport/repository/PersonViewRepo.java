package CashReport.repository;

import CashReport.model.views.PersonView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonViewRepo extends JpaRepository<PersonView, Integer> {
}
