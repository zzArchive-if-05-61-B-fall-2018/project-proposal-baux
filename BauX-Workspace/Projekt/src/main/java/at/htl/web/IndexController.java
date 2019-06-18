package at.htl.web;

import at.htl.facades.WorkerFacade;
import at.htl.model.Worker;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Model
@Named
public class IndexController implements Serializable {

    @Inject
    private WorkerFacade workerFacade;

    private List<Worker> worker;

    public IndexController() {
    }

    @PostConstruct
    public void init() {

        setWorker(workerFacade.GetAllWorker());
        System.out.println(worker.size());
    }

    public List<Worker> getWorker() {
        return worker;
    }

    public void setWorker(List<Worker> worker) {
        this.worker = worker;
    }


}
