package CashReport.repository;

import CashReport.model.CustomerView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepo extends JpaRepository<CustomerView, Integer> {

}
