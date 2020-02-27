package CashReport.controller.crud;

import CashReport.controller.service.PersonControllerService;
import CashReport.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    final PersonControllerService personControllerService;

    public PersonController(PersonControllerService personControllerService) {
        this.personControllerService = personControllerService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Person>> getAllPerson() {
        return ResponseEntity.status(HttpStatus.OK).body(personControllerService.getAllPerson());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Person> getAllPerson(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(personControllerService.getPerson(id));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).location(personControllerService.addPerson(person)).build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") int id) {
        personControllerService.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    @PreAuthorize(("hasRole('ROLE_ADMIN')"))
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        personControllerService.updatePerson(person);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
