package at.htl.facades;

import at.htl.model.Worker;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class WorkerFacade {

    @PersistenceContext
    EntityManager entityManager;

    public List<Worker> GetAllWorker() {

        //Erstellen eines Workers
        Worker w = new Worker();
        w.setName("firstName", " lastName");
        entityManager.persist(w);
        //---------------------------

        TypedQuery<Worker> query = entityManager.createNamedQuery("worker.getall", Worker.class);
        return query.getResultList();
    }

    public Worker loginForeman(String username, String password) {
       TypedQuery<Worker> query = entityManager.createNamedQuery("worker.login", Worker.class);
       query.setParameter("name", username);
       query.setParameter("password", password);

        try {
            return query.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("not found");
        }
        return null;
    }
}