package CashReport.model;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyid;
    private int orgnr;
    private String company;
    private String street;
    private String city;
    private String zipcode;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + companyid +
                ", orgnr=" + orgnr +
                ", name='" + company + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
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
