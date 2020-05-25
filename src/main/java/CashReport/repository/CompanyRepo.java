package CashReport.repository;


import CashReport.model.tables.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
