package CashReport.controller.view;

import CashReport.model.EmployeeView;
import CashReport.model.Person;
import CashReport.repository.EmployeeDetailsRepo;
import CashReport.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;

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
}
