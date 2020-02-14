package CashReport.controller;

import CashReport.model.CustomerDetails;
import CashReport.repository.CustomerDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<CustomerDetails> getCustomer(@PathVariable ("id") int id) {

        return customerDetailsRepo.findById(id);
    }
    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<CustomerDetails> getAllCustomers() {

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
