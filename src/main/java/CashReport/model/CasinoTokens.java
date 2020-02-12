package CashReport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CasinoTokens {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getStartFives() {
        return startFives;
    }

    public void setStartFives(int startFives) {
        this.startFives = startFives;
    }

    public int getStartTens() {
        return startTens;
    }

    public void setStartTens(int startTens) {
        this.startTens = startTens;
    }

    public int getStartTwenties() {
        return startTwenties;
    }

    public void setStartTwenties(int startTwenties) {
        this.startTwenties = startTwenties;
    }

    public int getStartFifties() {
        return startFifties;
    }

    public void setStartFifties(int startFifties) {
        this.startFifties = startFifties;
    }

    public int getStartHundreds() {
        return startHundreds;
    }

    public void setStartHundreds(int startHundreds) {
        this.startHundreds = startHundreds;
    }

    public int getStartChange() {
        return startChange;
    }

    public void setStartChange(int startChange) {
        this.startChange = startChange;
    }

    public int getStartSum() {
        return startSum;
    }

    public void setStartSum(int startSum) {
        this.startSum = startSum;
    }

    public int getEndFives() {
        return endFives;
    }

    public void setEndFives(int endFives) {
        this.endFives = endFives;
    }

    public int getEndTens() {
        return endTens;
    }

    public void setEndTens(int endTens) {
        this.endTens = endTens;
    }

    public int getEndTwenties() {
        return endTwenties;
    }

    public void setEndTwenties(int endTwenties) {
        this.endTwenties = endTwenties;
    }

    public int getEndFifties() {
        return endFifties;
    }

    public void setEndFifties(int endFifties) {
        this.endFifties = endFifties;
    }

    public int getEndHundreds() {
        return endHundreds;
    }

    public void setEndHundreds(int endHundreds) {
        this.endHundreds = endHundreds;
    }

    public int getEndChange() {
        return endChange;
    }

    public void setEndChange(int endChange) {
        this.endChange = endChange;
    }

    public int getEndSum() {
        return endSum;
    }

    public void setEndSum(int endSum) {
        this.endSum = endSum;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int reportId;
    private int startFives;
    private int startTens;
    private int startTwenties;
    private int startFifties;
    private int startHundreds;
    private int startChange;
    private int startSum;
    private int endFives;
    private int endTens;
    private int endTwenties;
    private int endFifties;
    private int endHundreds;
    private int endChange;
    private int endSum;
}