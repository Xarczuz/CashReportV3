package CashReport.repository;

import CashReport.model.tables.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report,Integer> {
}
