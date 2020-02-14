package CashReport.repository;

import CashReport.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, Integer> {


}
