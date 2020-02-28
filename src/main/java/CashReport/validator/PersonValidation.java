package CashReport.validator;

import CashReport.model.Person;
import java.util.function.Function;
import static CashReport.validator.PersonValidation.PersonEnum;
import static CashReport.validator.PersonValidation.PersonEnum.*;

public interface PersonValidation extends Function<Person, PersonEnum> {


    static PersonValidation nameValidator() {
        return person -> person.getFirstname().matches("[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,50}$") ? SUCCESS : NAME_NOT_VALID;
    };

    static PersonValidation lastNameValidator() {
        return person -> person.getLastname().matches("[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?]{1,50}$") ? SUCCESS : LASTNAME_NOT_VALID;
    };

    static PersonValidation phoneNumberValidator() {
        return person -> person.getPhonenr().matches("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$") ? SUCCESS : NUMBER_NOT_VALID;
    };

    static PersonValidation usernameValidator() {
        return person -> person.getUsername().matches("^[a-z0-9_-]{3,50}$") ? SUCCESS : USERNAME_NOT_VALID;
    };

    static PersonValidation emailValidator() {
        return person -> person.getEmail().matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$") ? SUCCESS : EMAIL_NOT_VALID;
    };

    default PersonValidation and (PersonValidation other){
        return person -> {
            PersonValidation.PersonEnum result = this.apply(person);
            return result.equals(SUCCESS) ? other.apply(person) : result;
        };
    }

    enum PersonEnum {
        NAME_NOT_VALID,
        EMAIL_NOT_VALID,
        LASTNAME_NOT_VALID,
        NUMBER_NOT_VALID,
        SUCCESS,
        USERNAME_NOT_VALID,
        PASSWORD_NOT_VALID,
        SALT_NOT_VALID,
        ROLE_NOT_VALID,
        COMPANY_NOT_VALID;
    }

}
