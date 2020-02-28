package CashReport.validator;

import CashReport.model.Company;
import org.junit.jupiter.api.Test;

import static CashReport.validator.CompanyValidation.*;
import static CashReport.validator.CompanyValidation.CompanyEnum.*;
import static org.junit.jupiter.api.Assertions.*;

class CompanyValidationTest {



    @Test
    void checkOrgNrValid(){
        Company companyOrgnr = new Company();
        companyOrgnr.setOrgnr("512345-5678");
        CompanyEnum result = checkOrgNrValidator().apply(companyOrgnr);
        assertEquals(SUCCESS,result);
    }

    @Test
    void checkOrgNrNotValid(){
        Company companyOrgnr = new Company();
        companyOrgnr.setOrgnr("1 4149");
        CompanyEnum result = checkOrgNrValidator().apply(companyOrgnr);
        assertEquals(ORGANISATION_NUMBER_NOT_VALID,result);
    }

    @Test
    void companyNameValid(){
        Company companyName = new Company();
        companyName.setCompany("Facebook");
        CompanyEnum result = companyNameValidator().apply(companyName);

        assertEquals(SUCCESS,result);
    }

    @Test
    void companyNameNotValid(){
        Company companyName = new Company();
        companyName.setCompany("Facebook?");
        CompanyEnum result = companyNameValidator().apply(companyName);

        assertEquals(COMPANY_NAME_NOT_VALID,result);
    }

    @Test
    void streetNameValid(){
        Company companyStreet = new Company();
        companyStreet.setStreet("Mantalsvägen 5A");
        CompanyEnum result = streetNameValidator().apply(companyStreet);

        assertEquals(SUCCESS,result);
    }
    @Test
    void streetNameNotValid(){
        Company companyStreet = new Company();
        companyStreet.setStreet("väg");
        CompanyEnum result = streetNameValidator().apply(companyStreet);

        assertEquals(STREET_NOT_VALID,result);
    }

    @Test
    void cityNameValid(){
        Company companyCityName = new Company();
        companyCityName.setCity("Stockholm");
        CompanyEnum result = cityNameValidation().apply(companyCityName);

        assertEquals(SUCCESS,result);
    }

    @Test
    void cityNameNotValid(){
        Company companyCityName = new Company();
        companyCityName.setCity("New_York");
        CompanyEnum result = cityNameValidation().apply(companyCityName);

        assertEquals(CITY_NOT_VALID,result);
    }

    @Test
    void zipCodeValid(){
        Company companyZipCode = new Company();
        companyZipCode.setZipcode("19149");
        CompanyEnum result = zipcodeValidation().apply(companyZipCode);

        assertEquals(SUCCESS,result);
    }

    @Test
    void zipCodeNotValid(){
        Company companyZipCode = new Company();
        companyZipCode.setZipcode("1-9149");
        CompanyEnum result = zipcodeValidation().apply(companyZipCode);

        assertEquals(ZIP_CODE_NOT_VALID,result);
    }


}