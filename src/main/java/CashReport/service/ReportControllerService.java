package CashReport.service;

import CashReport.model.tables.Report;

import java.util.List;

public interface ReportControllerService {
    Report addReport(Report report);

    Report getReport(int id);

    List<Report> getAllReports();

    void deleteReport(int id);

    void updateReport(Report report);
}
