package at.htl.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.*;

@NamedQueries({
        @NamedQuery(name="workPerDay.getall",query="select w from WorkPerDay w")
})
@Table
@Entity

public class WorkPerDay {
    @Id
    private int Id;
    private int staffId;
    private Date date;
    private int hours;

    //nur bei foremans
    private String ReportText;


    public WorkPerDay(){
    }

    //region Getter & Setter

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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


    //endregion
}
