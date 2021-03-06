package CashReport.controller;

import CashReport.model.tables.Person;
import CashReport.model.views.PersonView;
import CashReport.service.PersonControllerService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("person")
public class PersonController {

    final PersonControllerService personControllerService;

    public PersonController(PersonControllerService personControllerService) {
        this.personControllerService = personControllerService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<PersonView>> getAllPerson() {
        return ResponseEntity.status(HttpStatus.OK).body(personControllerService.getAllPerson());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PersonView> getPerson(@PathVariable("id") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personControllerService.getPerson(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PersonView> addPerson(@RequestBody Person person) {
        try {
            personControllerService.addPerson(person);
            return ResponseEntity.status(HttpStatus.OK).body(personControllerService.getPerson(person.getPersonid()));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") int id) {
        System.out.println(id);
        personControllerService.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        personControllerService.updatePerson(person);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
