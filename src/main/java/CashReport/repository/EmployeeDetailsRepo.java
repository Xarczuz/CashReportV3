package CashReport.repository;

import CashReport.model.views.EmployeeView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeView, Integer> {

}
