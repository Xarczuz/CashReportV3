package CashReport.controller.crud;

import CashReport.controller.service.ReportControllerService;
import CashReport.model.Report;
import CashReport.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    ReportControllerService reportControllerService;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Report> addReport(Report report) {
        Report tmpReport = reportControllerService.addReport(report);
        String template = "/report/{id}";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(template).buildAndExpand(tmpReport.getReportid());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Report> getReport(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(reportControllerService.getReport(id));
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Report>> getAllReports() {
        return ResponseEntity.status(HttpStatus.OK).body(reportControllerService.getAllReports());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteReport(@PathVariable("id") int id) {
        reportControllerService.deleteReport(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateReport(@RequestBody Report report) {
        reportControllerService.updateReport(report);
    }
}
