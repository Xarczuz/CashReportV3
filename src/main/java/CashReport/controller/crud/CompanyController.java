package CashReport.controller.crud;

import CashReport.controller.service.impl.CompanyControllerServiceImpl;
import CashReport.model.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    final CompanyControllerServiceImpl companyControllerServiceImpl;

    public CompanyController(CompanyControllerServiceImpl companyControllerServiceImpl) {
        this.companyControllerServiceImpl = companyControllerServiceImpl;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company tmpCompany = companyControllerServiceImpl.addCompany(company);
        String template = "/company/{id}";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(template).buildAndExpand(tmpCompany.getCompanyid());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.status(HttpStatus.OK).body(companyControllerServiceImpl.getAllCompanies());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Company> getCompany(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyControllerServiceImpl.getCompany(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCompany(@PathVariable("id") int id) {
        companyControllerServiceImpl.deleteCompany(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateCompany(@RequestBody Company company) {
        companyControllerServiceImpl.updateCompany(company);
    }
}
