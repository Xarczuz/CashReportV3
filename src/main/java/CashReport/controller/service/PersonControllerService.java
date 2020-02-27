package CashReport.controller.service;

import CashReport.model.Person;

import java.net.URI;
import java.util.List;

public interface PersonControllerService {
    URI addPerson(Person person);

    List<Person> getAllPerson();

    void deletePerson(int id);

    Person updatePerson(Person person);

    Person getPerson(int id);
}
