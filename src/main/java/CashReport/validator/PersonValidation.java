package CashReport.validator;

import CashReport.model.Person;
import java.util.function.Function;
import static CashReport.validator.PersonValidation.PersonEnum;
import static CashReport.validator.PersonValidation.PersonEnum.*;

public interface PersonValidation extends Function<Person, PersonEnum> {


    default PersonValidation nameValidator() {
        return person -> person.getFirstname().matches("[a-zA-]") ? SUCCESS : NAME_NOT_VALID;
    };

    default PersonValidation lastNameValidator() {
        return person -> person.getLastname().matches("[a-zA-]") ? SUCCESS : LASTNAME_NOT_VALID;
    };

    default PersonValidation phoneNumberValidator() {
        return person -> person.getPhonenr().matches("[0-9]*") ? SUCCESS : NUMBER_NOT_VALID;
    };

    default PersonValidation usernameValidator() {
        return person -> person.getUsername().length() > 50 ? SUCCESS : USERNAME_NOT_VALID;
    };

    default PersonValidation emailValidator() {
        return person -> person.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
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
