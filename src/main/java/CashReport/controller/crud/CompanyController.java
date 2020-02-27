package CashReport.controller.crud;

import CashReport.controller.service.CompanyControllerService;
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
    CompanyControllerService companyControllerService;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company tmpCompany = companyControllerService.addCompany(company);
        String template = "/company/{id}";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(template).buildAndExpand(tmpCompany.getCompanyid());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.status(HttpStatus.OK).body(companyControllerService.getAllCompanies());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Company> getCompany(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyControllerService.getCompany(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCompany(@PathVariable("id") int id) {
        companyControllerService.deleteCompany(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateCompany(@RequestBody Company company) {
        companyControllerService.updateCompany(company);
    }
}
