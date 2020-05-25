package CashReport.repository;

import CashReport.model.tables.CasinoTokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasinoTokensRepo extends JpaRepository<CasinoTokens,Integer> {

}
