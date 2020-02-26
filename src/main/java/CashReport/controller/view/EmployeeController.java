package CashReport.controller.view;

import CashReport.model.EmployeeView;
import CashReport.repository.EmployeeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addEmployee() {
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public EmployeeView getEmployee(@PathVariable("id") int id) {

        return employeeDetailsRepo.findById(id).get();
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<EmployeeView> getAllEmployees() {
        return employeeDetailsRepo.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeDetailsRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateEmployee(@PathVariable("id") int id) {

    }

}
