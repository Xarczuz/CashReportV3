package CashReport.controller.service;

import CashReport.model.Company;
import CashReport.repository.CompanyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyControllerService {

    final
    CompanyRepo companyRepo;

    public CompanyControllerService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public Company addCompany(Company company) {
        return companyRepo.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Company getCompany(int id) {
        return companyRepo.findById(id).get();
    }

    public void deleteCompany(int id) {
        companyRepo.deleteById(id);
    }

    public void updateCompany(Company company) {
        Company companyOne = companyRepo.getOne(company.getCompanyid());
        companyOne.setCompany(company.getCompany());
        companyOne.setOrgnr(company.getOrgnr());
        companyOne.setStreet(company.getStreet());
        companyOne.setCity(company.getCity());
        companyOne.setZipcode(company.getZipcode());
        companyRepo.save(companyOne);
    }
}
