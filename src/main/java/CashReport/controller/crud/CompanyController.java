package CashReport.controller.crud;

import CashReport.model.Company;
import CashReport.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    CompanyRepo companyRepo;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company tmpCompany = companyRepo.save(company);
        String template = "/company/{id}";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(template).buildAndExpand(tmpCompany.getCompanyid());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Company getCompany(@PathVariable("id") int id) {
        return companyRepo.findById(id).get();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCompany(@PathVariable("id") int id) {
        companyRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateCompany(@RequestBody Company company) {
        Company companyOne = companyRepo.getOne(company.getCompanyid());
        companyOne.setCompany(company.getCompany());
        companyOne.setOrgnr(company.getOrgnr());
        companyOne.setStreet(company.getStreet());
        companyOne.setCity(company.getCity());
        companyOne.setZipcode(company.getZipcode());
        companyRepo.save(companyOne);
    }
}
