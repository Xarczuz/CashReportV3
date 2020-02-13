package CashReport.controller;

import CashReport.model.UserAccount;
import CashReport.repository.UserRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class ExampleController {

    final
    UserRepo userRepo;

    public ExampleController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    @GetMapping(path = "{Username}")
//    public String getPerson(@PathVariable("Username") String username){
//            return personRepo.findByUsername(username).get().getUsername();
////        return personRepo.findAll();
//    }

    @GetMapping(path = "test")
    @PreAuthorize("hasRole('ROLE_3')")
    public List<UserAccount> getAll() {
        return userRepo.findAll();
    }

    @GetMapping("employee")
    @PreAuthorize("hasRole('ROLE_Employee')")
    public List<UserAccount> getAllUser() {
        return userRepo.findAll();
    }


}
