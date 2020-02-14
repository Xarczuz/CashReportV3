package CashReport.controller;

import CashReport.model.CompanyModel;
import CashReport.model.EmployeeDetails;
import CashReport.repository.CompanyRepo;
import CashReport.repository.EmployeeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    CompanyRepo companyRepo;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addCompany() {

    }

    @GetMapping("")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<CompanyModel> getAllCompanies() {
        return companyRepo.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CompanyModel getCompany(@PathVariable("id") int id) {
        return companyRepo.findById(id).get();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCompany(@PathVariable("id") int id) {
        companyRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateCompany(@RequestBody CompanyModel companyModel) {
        CompanyModel companyModelOne = companyRepo.getOne(companyModel.getCompanyid());
        companyModelOne.setCompany(companyModel.getCompany());
        companyModelOne.setOrgnr(companyModel.getOrgnr());
        companyModelOne.setStreet(companyModel.getStreet());
        companyModelOne.setCity(companyModel.getCity());
        companyModelOne.setZipcode(companyModel.getZipcode());
        companyRepo.save(companyModelOne);
    }
}
