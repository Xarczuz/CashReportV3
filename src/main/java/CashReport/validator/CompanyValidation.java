package CashReport.validator;

import CashReport.model.Company;

import java.util.function.Function;

import static CashReport.validator.CompanyValidation.CompanyEnum;
import static CashReport.validator.CompanyValidation.CompanyEnum.*;


public interface CompanyValidation extends Function<Company, CompanyEnum> {


    static CompanyValidation checkOrgNrValidator() {
        return company -> company.getOrgnr().matches("([5]\\d{5}[-]\\d{4})|([5]\\d{9})") ? SUCCESS : ORGANISATION_NUMBER_NOT_VALID;
    }

    static CompanyValidation companyNameValidator() {
        return company -> company.getCompany().matches("^((?![\\^!@#$*~ <>?]).)((?![\\^!@#$*~<>?]).){0,73}((?![\\^!@#$*~ <>?]).)$") ? SUCCESS : COMPANY_NAME_NOT_VALID;
    }

    static CompanyValidation streetNameValidator() {
        return company -> company.getStreet().matches("^[a-zåäöA-ZÅÄÖ0-9, ]{4,50}") ? SUCCESS : STREET_NOT_VALID;
    }

    static CompanyValidation cityNameValidation() {
        return company -> company.getCity().matches("[a-zA-Z]+(?:[ '-][a-zA-Z]+)*") ? SUCCESS : CITY_NOT_VALID;
    }

    static CompanyValidation zipcodeValidation() {
        return company -> company.getZipcode().matches("^\\d{5}|\\d{3}[- ]\\d{2}") ? SUCCESS : ZIP_CODE_NOT_VALID;//Bara Svenska PostNr.
    }

    default CompanyValidation and(CompanyValidation other) {
        return company -> {
            CompanyEnum result = this.apply(company);
            return result.equals(SUCCESS) ? other.apply(company) : result;
        };
    }

    enum CompanyEnum {
        ORGANISATION_NUMBER_NOT_VALID,
        COMPANY_NAME_NOT_VALID,
        STREET_NOT_VALID,
        CITY_NOT_VALID,
        ZIP_CODE_NOT_VALID,
        SUCCESS;
    }
}
