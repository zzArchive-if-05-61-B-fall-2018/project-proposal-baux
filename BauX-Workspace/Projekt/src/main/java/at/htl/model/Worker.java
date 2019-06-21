package at.htl.model;


import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "worker.getall", query = "select d from Worker d"),
        @NamedQuery(name = "worker.login", query = "select d from Worker d where d.isForeman = true AND d.Name = :name AND d.password = :password")
})

@Table
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private boolean isForeman;
    private int groupId;
    private String password;
    private int hours;

    @OneToMany
    private List<WorkPerDay> workerPerDayList;


    public Worker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String firstName, String lastName)
    {
        Name = firstName + ' ' + lastName;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isForeman() {
        return isForeman;
    }

    public void setForeman(boolean foreman) {
        isForeman = foreman;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<WorkPerDay> getWorkerPerDayList() {
        return workerPerDayList;
    }

    public void setWorkerPerDayList(List<WorkPerDay> workerPerDayList) {
        this.workerPerDayList = workerPerDayList;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
