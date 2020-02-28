package CashReport.validator;

import CashReport.model.Person;
import org.junit.jupiter.api.Test;

import static CashReport.validator.PersonValidation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonValidationTest {
    @Test
    void personNameValid() {
        Person personName = new Person();
        personName.setFirstname("Erik-Ddaniel");
        PersonEnum result = nameValidator().apply(personName);

        assertEquals(PersonEnum.SUCCESS, result);
    }

    @Test
    void personNameNotValid() {
        Person personName = new Person();
        personName.setFirstname("Erik-Daniel?");
        PersonEnum result = nameValidator().apply(personName);

        assertEquals(PersonEnum.NAME_NOT_VALID, result);
    }

    @Test
    void personLastnameNotValid() {
        Person personLastName = new Person();
        personLastName.setLastname("Hedman-1kdasjdkasjdkjdiasjdkjaskldjkasdjlasjdlkjasbgfdshfjkjkasjdklasjdkljasdkljasdjasdasadsada");
        PersonEnum result = lastNameValidator().apply(personLastName);

        assertEquals(PersonEnum.LASTNAME_NOT_VALID, result);
    }

    @Test
    void personLastnameValid() {
        Person personLastName = new Person();
        personLastName.setLastname("Hedman");
        PersonEnum result = lastNameValidator().apply(personLastName);

        assertEquals(PersonEnum.SUCCESS, result);
    }

    @Test
    void usernameValid() {
        Person personUsername = new Person();
        personUsername.setUsername("hedman");
        PersonEnum result = usernameValidator().apply(personUsername);

        assertEquals(PersonEnum.SUCCESS, result);
    }

    @Test
    void usernameNotValid() {
        Person personUsername = new Person();
        personUsername.setUsername("Hedman!");
        PersonEnum result = usernameValidator().apply(personUsername);

        assertEquals(PersonEnum.USERNAME_NOT_VALID, result);
    }

    @Test
    void phoneNumberValid() {
        Person personPhoneNumber = new Person();
        personPhoneNumber.setPhonenr("070-5593300");
        PersonEnum result = phoneNumberValidator().apply(personPhoneNumber);

        assertEquals(PersonEnum.SUCCESS, result);
    }

    @Test
    void phoneNumberNotValid() {
        Person personPhoneNumber = new Person();
        personPhoneNumber.setPhonenr("07055995_");
        PersonEnum result = phoneNumberValidator().apply(personPhoneNumber);

        assertEquals(PersonEnum.NUMBER_NOT_VALID, result);
    }


    @Test
    void personValidation() {
        Person erikHedman = new Person();
        erikHedman.setFirstname("Erik");
        erikHedman.setLastname("Hedman");
        erikHedman.setPhonenr("070700707");
        erikHedman.setUsername("erikhedman1231__");
        erikHedman.setEmail("erikHedman@gmail.com");
        //----
        erikHedman.setCompanyid(213);
        erikHedman.setSalt("asdasd");
        erikHedman.setRoleid(2123);
        erikHedman.setPersonid(2131);

        PersonEnum result = nameValidator()
                .and(lastNameValidator())
                .and(phoneNumberValidator())
                .and(usernameValidator())
                .and(emailValidator())
                .apply(erikHedman);

        assertEquals(PersonEnum.SUCCESS, result);
    }


}