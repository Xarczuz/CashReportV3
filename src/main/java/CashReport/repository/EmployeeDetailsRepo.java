package CashReport.repository;

import CashReport.model.EmployeeView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeView, Integer> {

}
