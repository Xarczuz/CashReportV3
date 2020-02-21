package CashReport.controller;


import CashReport.model.Person;
import CashReport.model.Report;
import CashReport.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {
    @Autowired
    PersonRepo personRepo;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Person> getAllPerson(){
        return personRepo.findAll();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Person addPerson(@RequestBody Person person){
        return personRepo.save(person);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePerson(@PathVariable("id") int id){
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
