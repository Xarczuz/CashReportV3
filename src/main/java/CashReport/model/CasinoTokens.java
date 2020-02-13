package CashReport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CasinoTokens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int reportid;
    private int startfives;
    private int starttens;
    private int starttwenties;
    private int startfifties;
    private int starthundreds;
    private int startchange;
    private int startsum;
    private int endfives;
    private int endtens;
    private int endtwenties;
    private int endfifties;
    private int endhundreds;
    private int endchange;
    private int endsum;

    @Override
    public String toString() {
        return "CasinoTokens{" +
                "id=" + id +
                ", reportid=" + reportid +
                ", startfives=" + startfives +
                ", starttens=" + starttens +
                ", starttwenties=" + starttwenties +
                ", startfifties=" + startfifties +
                ", starthundreds=" + starthundreds +
                ", startchange=" + startchange +
                ", startsum=" + startsum +
                ", endfives=" + endfives +
                ", endtens=" + endtens +
                ", endtwenties=" + endtwenties +
                ", endfifties=" + endfifties +
                ", endhundreds=" + endhundreds +
                ", endchange=" + endchange +
                ", endsum=" + endsum +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReportid() {
        return reportid;
    }

    public void setReportid(int reportid) {
        this.reportid = reportid;
    }

    public int getStartfives() {
        return startfives;
    }

    public void setStartfives(int startfives) {
        this.startfives = startfives;
    }

    public int getStarttens() {
        return starttens;
    }

    public void setStarttens(int starttens) {
        this.starttens = starttens;
    }

    public int getStarttwenties() {
        return starttwenties;
    }
    public void setStarttwenties(int starttwenties) {
        this.starttwenties = starttwenties;
    }

    public int getStartfifties() {
        return startfifties;
    }

    public void setStartfifties(int startfifties) {
        this.startfifties = startfifties;
    }

    public int getStarthundreds() {
        return starthundreds;
    }

    public void setStarthundreds(int starthundreds) {
        this.starthundreds = starthundreds;
    }

    public int getStartchange() {
        return startchange;
    }

    public void setStartchange(int startchange) {
        this.startchange = startchange;
    }

    public int getStartsum() {
        return startsum;
    }

    public void setStartsum(int startsum) {
        this.startsum = startsum;
    }

    public int getEndfives() {
        return endfives;
    }

    public void setEndfives(int endfives) {
        this.endfives = endfives;
    }

    public int getEndtens() {
        return endtens;
    }

    public void setEndtens(int endtens) {
        this.endtens = endtens;
    }

    public int getEndtwenties() {
        return endtwenties;
    }

    public void setEndtwenties(int endtwenties) {
        this.endtwenties = endtwenties;
    }

    public int getEndfifties() {
        return endfifties;
    }

    public void setEndfifties(int endfifties) {
        this.endfifties = endfifties;
    }

    public int getEndhundreds() {
        return endhundreds;
    }

    public void setEndhundreds(int endhundreds) {
        this.endhundreds = endhundreds;
    }

    public int getEndchange() {
        return endchange;
    }

    public void setEndchange(int endchange) {
        this.endchange = endchange;
    }

    public int getEndsum() {
        return endsum;
    }

    public void setEndsum(int endsum) {
        this.endsum = endsum;
    }
}