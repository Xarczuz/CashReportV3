package CashReport.controller;

import CashReport.model.views.EmployeeView;
import CashReport.repository.EmployeeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
