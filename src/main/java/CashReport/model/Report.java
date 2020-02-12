package CashReport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportid;
    private String gametablename;
    private String location;
    private String employeesign;
    private String customersign;
    private Double digitalcashflow;
    private Double cashflow;
    private Double revenue;
    private Double payment;
    private String infofield;
    private String status;

    @Override
    public String toString() {
        return "Report{" +
                "id=" + reportid +
                ", gametablename='" + gametablename + '\'' +
                ", location='" + location + '\'' +
                ", employeesign='" + employeesign + '\'' +
                ", customersign='" + customersign + '\'' +
                ", digitalcashflow=" + digitalcashflow +
                ", cashflow=" + cashflow +
                ", revenue=" + revenue +
                ", payment=" + payment +
                ", infofield='" + infofield + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getReportid() {
        return reportid;
    }

    public void setReportid(int reportid) {
        this.reportid = reportid;
    }

    public String getGametablename() {
        return gametablename;
    }

    public void setGametablename(String gametablename) {
        this.gametablename = gametablename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmployeesign() {
        return employeesign;
    }

    public void setEmployeesign(String employeesign) {
        this.employeesign = employeesign;
    }

    public String getCustomersign() {
        return customersign;
    }

    public void setCustomersign(String customersign) {
        this.customersign = customersign;
    }

    public Double getDigitalcashflow() {
        return digitalcashflow;
    }

    public void setDigitalcashflow(Double digitalcashflow) {
        this.digitalcashflow = digitalcashflow;
    }

    public Double getCashflow() {
        return cashflow;
    }

    public void setCashflow(Double cashflow) {
        this.cashflow = cashflow;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getInfofield() {
        return infofield;
    }

    public void setInfofield(String infofield) {
        this.infofield = infofield;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
