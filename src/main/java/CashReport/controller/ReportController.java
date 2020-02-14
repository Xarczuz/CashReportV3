package CashReport.controller;

import CashReport.model.Report;
import CashReport.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    ReportRepo reportRepo;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addReport(Report report) {
        reportRepo.save(report);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Report getReport(@PathVariable("id") int id) {
        return reportRepo.findById(id).get();
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Report> getAllReports() {

        return reportRepo.findAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteReport(@PathVariable("id") int id) {

        reportRepo.deleteById(id);
    }

    @PutMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateReport(@RequestBody Report report) {
        Report report1 = reportRepo.getOne(report.getReportid());
        report1.setCustomersign(report.getCustomersign());
        report1.setEmployeesign(report.getEmployeesign());
        report1.setGametablename(report.getGametablename());
        report1.setCashflow(report.getCashflow());
        report1.setDigitalcashflow(report.getDigitalcashflow());
        report1.setPayment(report.getPayment());
        report1.setRevenue(report.getRevenue());
        report1.setLocation(report.getLocation());
        report1.setInfofield(report.getInfofield());
        report1.setStatus(report.getStatus());
        reportRepo.save(report1);

    }
}
