package CashReport.controller;

import CashReport.model.Person;
import CashReport.repository.PersonRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

    final PersonRepo personRepo;

    public ExampleController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("person")
    @PreAuthorize("hasRole('ROLE_1')")
    public List<Person> getPerson() {
        return personRepo.findAll();
    }
}
