package CashReport.repository;

import CashReport.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Report,Integer> {
}
