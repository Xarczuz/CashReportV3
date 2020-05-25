package CashReport.repository;

import CashReport.model.tables.TimeStamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeStampRepo extends JpaRepository<TimeStamp, Integer> {
}
