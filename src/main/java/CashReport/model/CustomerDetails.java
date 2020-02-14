package CashReport.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "customerdetails")
@Immutable
public class CustomerDetails {
    @Id

    private int personid;
    private String role;
    private String fullname;
    private String email;
    private String phonenr;
    private int orgnr;
    private String company;
    private String street;
    private String city;
    private String zipcode;

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "personid=" + personid +
                ", role='" + role + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phonenr='" + phonenr + '\'' +
                ", orgnr=" + orgnr +
                ", company='" + company + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public int getOrgnr() {
        return orgnr;
    }

    public void setOrgnr(int orgnr) {
        this.orgnr = orgnr;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
