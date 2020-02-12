package CashReport.repository;

import CashReport.model.TimeStamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeStampRepo extends JpaRepository<TimeStamp, Integer> {
}
