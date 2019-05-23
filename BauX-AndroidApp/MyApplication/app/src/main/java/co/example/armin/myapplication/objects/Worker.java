package co.example.armin.myapplication.objects;

public class Worker {
    private int workerID;
    private String workerName;
    private Double workedHours;

    public Worker(int workerID, String workerName, Double workedHours){
        this.workerID = workerID;
        this.workerName = workerName;
        this.workedHours = workedHours;
    }


    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Double workedHours) {
        this.workedHours = workedHours;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }
}
