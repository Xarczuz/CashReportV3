package CashReport.repository;

import CashReport.model.tables.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepo extends JpaRepository<Permission,Integer> {
}
