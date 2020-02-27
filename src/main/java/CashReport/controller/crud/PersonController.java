package CashReport.controller.crud;

import CashReport.controller.service.impl.PersonControllerServiceImpl;
import CashReport.model.Person;
import CashReport.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    PersonRepo personRepo;
    @Autowired
    PersonControllerServiceImpl personControllerServiceImpl;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return ResponseEntity.created(personControllerServiceImpl.addPerson(person).toUri()).build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePerson(@PathVariable("id") int id) {
        personRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize(("hasRole('ROLE_ADMIN')"))
    public Person updatePerson(@RequestBody Person person) {
        return personControllerServiceImpl.updatePerson(person);
    }
}
