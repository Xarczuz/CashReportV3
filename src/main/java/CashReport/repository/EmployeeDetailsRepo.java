package CashReport.repository;

import CashReport.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails,Integer> {

}
