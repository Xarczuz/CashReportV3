package CashReport.controller;

import CashReport.model.tables.Report;
import CashReport.service.impl.ReportControllerServiceImpl;
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

    final ReportControllerServiceImpl reportControllerServiceImpl;

    public ReportController(ReportControllerServiceImpl reportControllerServiceImpl) {
        this.reportControllerServiceImpl = reportControllerServiceImpl;
    }

    //    @PreAuthorize("hasAnyRole('[ROLE_ADMIN,ROLE_EMPLOYEE]')")
    @PostMapping("")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        Report tmpReport = reportControllerServiceImpl.addReport(report);
        String template = "/report/{id}";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(template).buildAndExpand(tmpReport.getReportid());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
    public ResponseEntity<Report> getReport(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(reportControllerServiceImpl.getReport(id));
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
    public ResponseEntity<List<Report>> getAllReports() {
        return ResponseEntity.status(HttpStatus.OK).body(reportControllerServiceImpl.getAllReports());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteReport(@PathVariable("id") int id) {
        reportControllerServiceImpl.deleteReport(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateReport(@RequestBody Report report) {
        reportControllerServiceImpl.updateReport(report);
    }
}
