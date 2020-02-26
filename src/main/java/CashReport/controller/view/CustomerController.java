package CashReport.controller.view;

import CashReport.model.CustomerView;
import CashReport.repository.CustomerDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    //private CustomerService customerService;

    @Autowired
    CustomerDetailsRepo customerDetailsRepo;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addCustomer() {

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CustomerView getCustomer(@PathVariable("id") int id) {

        return customerDetailsRepo.findById(id).get();
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<CustomerView> getAllCustomers() {

        return customerDetailsRepo.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCustomer(@PathVariable("id") int id) {

        customerDetailsRepo.deleteById(id);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateCustomer(@PathVariable("id") int id) {

      // customerDetailsRepo.save(id);
    }

}
