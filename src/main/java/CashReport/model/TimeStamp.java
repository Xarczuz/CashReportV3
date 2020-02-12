package CashReport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeStampid;
    private Date checkIn;
    private Date checkout;
    private int personId;

    @Override
    public String toString() {
        return "TimeStamp{" +
                "timeStampid=" + timeStampid +
                ", checkIn=" + checkIn +
                ", checkout=" + checkout +
                ", personId=" + personId +
                '}';
    }

    public int getTimeStampid() {
        return timeStampid;
    }

    public void setTimeStampid(int timeStampid) {
        this.timeStampid = timeStampid;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
