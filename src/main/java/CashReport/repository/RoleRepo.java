package CashReport.repository;

import CashReport.model.tables.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RoleRepo extends JpaRepository<Role, Integer> {
}
