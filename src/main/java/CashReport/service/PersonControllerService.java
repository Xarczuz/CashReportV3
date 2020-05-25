package CashReport.service;

import CashReport.model.tables.Person;
import CashReport.model.views.PersonView;

import java.net.URI;
import java.util.List;

public interface PersonControllerService {
    URI addPerson(Person person);

    List<PersonView> getAllPerson();

    void deletePerson(int id);

    Person updatePerson(Person person);

    PersonView getPerson(int id);
}
