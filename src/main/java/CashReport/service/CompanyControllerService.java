package CashReport.service;

import CashReport.model.tables.Company;

import java.util.List;

public interface CompanyControllerService {
    Company addCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompany(int id);

    void deleteCompany(int id);

    void updateCompany(Company company);
}
