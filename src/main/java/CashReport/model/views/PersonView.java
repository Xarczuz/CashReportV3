package CashReport.model.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "personview")
@Immutable
public class PersonView {
    @Id
    private int personid;
    private int roleid;
    private int companyid;
    private String firstname;
    private String lastname;
    private String email;
    private String phonenr;
    private String username;

    @Override
    public String toString() {
        return "PersonView{" +
                "personid=" + personid +
                ", roleid=" + roleid +
                ", companyid=" + companyid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phonenr='" + phonenr + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenr() {
        return phonenr;
    }

    public void setPhonenr(String phonenr) {
        this.phonenr = phonenr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
