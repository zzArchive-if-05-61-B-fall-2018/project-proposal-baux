package co.example.armin.myapplication.objects;

import java.util.ArrayList;
import java.util.List;

public class WorkerList {
    private List<Worker> workers;

    public WorkerList(){
        workers = new ArrayList<>();
    }

    public void addWorker(Worker worker){
        if(findWorkerByName(worker.getWorkerName()) == null){
            workers.add(worker);
            //sort();
            //setChanges();
        }
    }
    public void renameWorker(Worker worker){
        workers.remove(worker);
        //setChanges();
    }

    public void addWorkerList(List<Worker> worker){
        workers.addAll(worker);
        //sort();
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public Worker findWorkerByName(String name){
        for (Worker worker:workers) {
            if (worker.getWorkerName().equals(name)){
                return worker;
            }
        }
        return null;
    }
    public List<String> getWorkerNames(){
        List<String> names = new ArrayList<>();
        for (Worker worker:workers) {
            names.add(worker.getWorkerName());
        }
        return names;
    }

    /*private void setChanges(){
        Save.save(this);
    }
    private void sort(){
        Collections.sort(workers);
    }*/

}
