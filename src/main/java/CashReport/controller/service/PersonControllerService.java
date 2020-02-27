package CashReport.controller.service;

import CashReport.model.Person;
import org.springframework.web.util.UriComponents;

public interface PersonControllerService {
    
    UriComponents addPerson(Person person);
    Person updatePerson(Person person);
}
