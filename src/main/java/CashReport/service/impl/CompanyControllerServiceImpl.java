package CashReport.service.impl;

import CashReport.model.tables.Company;
import CashReport.repository.CompanyRepo;
import CashReport.service.CompanyControllerService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CompanyControllerServiceImpl implements CompanyControllerService {

    private final CompanyRepo companyRepo;

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
        try {
            Company companyOne = companyRepo.getOne(company.getCompanyid());
            companyOne.setCompany(company.getCompany());
            companyOne.setOrgnr(company.getOrgnr());
            companyOne.setStreet(company.getStreet());
            companyOne.setCity(company.getCity());
            companyOne.setZipcode(company.getZipcode());
            companyRepo.save(companyOne);

        } catch (EntityNotFoundException e) {

        }

    }
}
