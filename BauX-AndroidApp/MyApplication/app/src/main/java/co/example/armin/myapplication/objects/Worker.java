package co.example.armin.myapplication.objects;

import java.io.Serializable;
import java.util.List;

public class Worker implements Serializable {

    private int workerId;
    private String workerName;
    private boolean isForeman;
    private int groupId;
    private String password;
    private List<WorkPerDay> workerPerDayList;

    public Worker(String workerId, String string, String password, int userid) {
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setName(String firstName, String lastName)
    {
        workerName = firstName + ' ' + lastName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
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
}
