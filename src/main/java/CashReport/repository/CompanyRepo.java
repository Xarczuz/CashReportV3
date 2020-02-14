package CashReport.repository;


import CashReport.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<CompanyModel,Integer> {

}
