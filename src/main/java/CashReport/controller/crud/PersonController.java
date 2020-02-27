package CashReport.controller.crud;

import CashReport.model.Company;
import CashReport.model.Person;
import CashReport.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person tmpPerson = personRepo.save(person);
        String template = "/person/{id}";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(template).buildAndExpand(tmpPerson.getPersonid());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePerson(@PathVariable("id") int id) {
        personRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize(("has('ROLE_ADMIN')"))
    public Person updatePerson(@RequestBody Person person) {
        Person person1 = new Person();
        person1.setRoleid(person.getRoleid());
        person1.setCompanyid(person.getCompanyid());
        person1.setFirstname(person.getFirstname());
        person1.setLastname(person.getLastname());
        person1.setEmail(person.getEmail());
        person1.setPhonenr(person.getPhonenr());
        person1.setPassword(person.getPassword());
        person1.setUsername(person.getUsername());
        person1.setSalt(person.getSalt());
        return personRepo.save(person1);
    }
}
