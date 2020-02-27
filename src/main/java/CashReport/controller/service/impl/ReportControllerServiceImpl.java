package CashReport.controller.service.impl;

import CashReport.controller.service.ReportControllerService;
import CashReport.model.Report;
import CashReport.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ReportControllerServiceImpl implements ReportControllerService {

    final
    ReportRepo reportRepo;

    public ReportControllerServiceImpl(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    @Override
    public Report addReport(Report report) {
        return reportRepo.save(report);
    }

    @Override
    public Report getReport(int id) {
        return reportRepo.findById(id).get();
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepo.findAll();
    }
    @Override
    public void deleteReport(int id) {
        reportRepo.deleteById(id);
    }

    @Override
    public void updateReport(Report report) {
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
