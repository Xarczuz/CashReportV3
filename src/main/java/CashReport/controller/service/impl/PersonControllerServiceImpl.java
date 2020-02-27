package CashReport.controller.service.impl;

import CashReport.controller.service.PersonControllerService;
import CashReport.model.Person;
import CashReport.repository.PersonRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class PersonControllerServiceImpl implements
        PersonControllerService {
  

    private PersonRepo personRepo;

    public PersonControllerServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }


    

    @Override
    public  UriComponents addPerson(Person person) {
        Person tmpPerson = personRepo.save(person);
        String template = "/person/{id}";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(template).buildAndExpand(tmpPerson.getPersonid());
        return  uriComponents;
    }


    @Override
    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }
    

    @Override
    public void deletePerson(int id) {personRepo.deleteById(id);}
    

    @Override
    public Person updatePerson(Person person) {

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
