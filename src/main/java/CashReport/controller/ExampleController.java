package CashReport.controller;

import CashReport.model.Person;
import CashReport.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("person")
    public List<Person> getPerson(){

        return personRepo.findAll();
    }
}
