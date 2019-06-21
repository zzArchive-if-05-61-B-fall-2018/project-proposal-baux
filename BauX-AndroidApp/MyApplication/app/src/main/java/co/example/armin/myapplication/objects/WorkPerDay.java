package co.example.armin.myapplication.objects;

import java.util.Date;

public class WorkPerDay {

    private int Id;
    private Date date;
    private int hours;
    private String ReportText;


    public WorkPerDay(){
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getReportText() {
        return ReportText;
    }

    public void setReportText(String reportText) {
        ReportText = reportText;
    }
}
