package at.htl.web;

import at.htl.facades.WorkerFacade;
import at.htl.facades.WorkerGroupFacade;
import at.htl.model.Worker;
import at.htl.model.WorkerGroup;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Model
@Named
public class IndexController implements Serializable {

    @Inject
    private WorkerFacade workerFacade;
    @Inject
    private WorkerGroupFacade workerGroupFacade;

    private Date filterDate;

    private List<Worker> worker;
    private List<WorkerGroup> workerGroups;

    public IndexController() {
    }

    @PostConstruct
    public void init() {
        setWorker(workerFacade.GetAllWorker());
        setWorkerGroups(workerGroupFacade.GetAllGroups());
    }

    public Date getFilterDate() {
        return filterDate;
    }

    public void setFilterDate(Date filterDate) {
        this.filterDate = filterDate;
    }

    public List<Worker> getWorker() {
        return worker;
    }

    public void setWorker(List<Worker> worker) {
        this.worker = worker;
    }


    public List<WorkerGroup> getWorkerGroups() {
        return workerGroups;
    }

    public void setWorkerGroups(List<WorkerGroup> workerGroups) {
        this.workerGroups = workerGroups;
    }
}
