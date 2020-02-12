package CashReport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gameTableName;
    private String location;
    private String employeeSign;
    private String customerSign;
    private Double digitalCashFlow;
    private Double cashFlow;
    private Double revenue;
    private Double payment;
    private String infoField;
    private String status;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getGameTableName() {
                return gameTableName;
        }

        public void setGameTableName(String gameTableName) {
                this.gameTableName = gameTableName;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public String getEmployeeSign() {
                return employeeSign;
        }

        public void setEmployeeSign(String employeeSign) {
                this.employeeSign = employeeSign;
        }

        public String getCustomerSign() {
                return customerSign;
        }

        public void setCustomerSign(String customerSign) {
                this.customerSign = customerSign;
        }

        public Double getDigitalCashFlow() {
                return digitalCashFlow;
        }

        public void setDigitalCashFlow(Double digitalCashFlow) {
                this.digitalCashFlow = digitalCashFlow;
        }

        public Double getCashFlow() {
                return cashFlow;
        }

        public void setCashFlow(Double cashFlow) {
                this.cashFlow = cashFlow;
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

        public String getInfoField() {
                return infoField;
        }

        public void setInfoField(String infoField) {
                this.infoField = infoField;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }
}
