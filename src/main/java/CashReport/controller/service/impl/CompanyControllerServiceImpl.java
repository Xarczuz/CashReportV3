package CashReport.controller.service.impl;

import CashReport.controller.service.CompanyControllerService;
import CashReport.model.Company;
import CashReport.repository.CompanyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyControllerServiceImpl implements CompanyControllerService {

    final
    CompanyRepo companyRepo;

    public CompanyControllerServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Company getCompany(int id) {
        return companyRepo.findById(id).get();
    }

    @Override
    public void deleteCompany(int id) {
        companyRepo.deleteById(id);
    }

    @Override
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
