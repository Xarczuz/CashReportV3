package CashReport.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeedetails")
@Immutable
public class EmployeeView {
    @Id
    private int personid;
    private String email;
    private String fullname;
    private String phonenr;
    private String role;

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "personID=" + personid+
                ", email='" + email + '\'' +
                ", fullName='" + fullname + '\'' +
                ", phoneNr='" + phonenr + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhonenr() {
        return phonenr;
    }

    public void setPhonenr(String phonenr) {
        this.phonenr = phonenr;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
