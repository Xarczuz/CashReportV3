package CashReport.controller.service;

import CashReport.model.Person;
import org.springframework.web.util.UriComponents;

import java.util.List;

public interface PersonControllerService {
    UriComponents addPerson(Person person);

    List<Person> getAllPerson();

    void deletePerson(int id);

    Person updatePerson(Person person);
}
