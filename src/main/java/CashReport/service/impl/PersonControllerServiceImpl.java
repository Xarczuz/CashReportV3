package CashReport.service.impl;

import CashReport.model.tables.Person;
import CashReport.model.views.PersonView;
import CashReport.repository.PersonRepo;
import CashReport.repository.PersonViewRepo;
import CashReport.service.PersonControllerService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonControllerServiceImpl implements
        PersonControllerService {

    private final PersonRepo personRepo;
    private final PersonViewRepo personViewRepo;
    private final PasswordEncoder passwordEncoder;


    public PersonControllerServiceImpl(PersonRepo personRepo, PersonViewRepo personViewRepo, PasswordEncoder passwordEncoder) {
        this.personRepo = personRepo;
        this.personViewRepo = personViewRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public URI addPerson(Person person) throws DataIntegrityViolationException {
        String encryptedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encryptedPassword);
        Person tmpPerson = personRepo.save(person);
        String template = "/person/{id}";
        return UriComponentsBuilder.fromUriString(template).buildAndExpand(tmpPerson.getPersonid()).toUri();
    }

    @Override
    public List<PersonView> getAllPerson() {
        return personViewRepo.findAll();
    }

    @Override
    public void deletePerson(int id) {
        personRepo.deleteById(id);
    }

    @Override
    public Person updatePerson(Person person) {
        Person person1 = personRepo.getOne(person.getPersonid());
        person1.setRoleid(person.getRoleid());
        person1.setCompanyid(person.getCompanyid());
        person1.setFirstname(person.getFirstname());
        person1.setLastname(person.getLastname());
        person1.setEmail(person.getEmail());
        person1.setPhonenr(person.getPhonenr());
        //person1.setPassword(person.getPassword());
        person1.setUsername(person.getUsername());
        //person1.setSalt(person.getSalt());
        return personRepo.save(person1);
    }

    @Override
    public PersonView getPerson(int id) throws NoSuchElementException {
        return personViewRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
