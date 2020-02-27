package CashReport.controller.service;

import CashReport.model.Company;

import java.util.List;

public interface CompanyControllerService {
    Company addCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompany(int id);

    void deleteCompany(int id);

    void updateCompany(Company company);
}
