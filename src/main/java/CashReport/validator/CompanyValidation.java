package CashReport.validator;

import CashReport.model.Company;
import java.util.function.Function;
import static CashReport.validator.CompanyValidation.CompanyEnum;
import static CashReport.validator.CompanyValidation.CompanyEnum.*;


public interface CompanyValidation extends Function<Company,CompanyEnum> {



   default CompanyValidation checkOrgNrValidator(){
       return company -> company.getOrgnr() > 0 ? SUCCESS : ORGANISATION_NUMBER_NOT_VALID;
   };

   default CompanyValidation companyNameValidator(){
       return company -> company.getCompany().length() > 50 ? SUCCESS : COMPANY_NAME_NOT_VALID;
   }

   default CompanyValidation streetNameValidator(){
       return company -> {
           return company.getStreet().matches("[a-zA-Z].+") ? SUCCESS: STREET_NOT_VALID; //Regex check if first char is a letter
       };
   }

   default CompanyValidation cityValidation(){
       return company -> company.getCity().matches("[a-zA-Z]") ? SUCCESS : CITY_NOT_VALID;
   }

   default CompanyValidation zipcodeValidation(){
       return company -> company.getZipcode().matches("[0-9 ]+") ? SUCCESS : ZIP_CODE_NOT_VALID;
   }

   default CompanyValidation and (CompanyValidation other){
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
