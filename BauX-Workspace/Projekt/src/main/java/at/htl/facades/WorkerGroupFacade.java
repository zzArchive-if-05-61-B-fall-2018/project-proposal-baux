package at.htl.facades;

import at.htl.model.WorkerGroup;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class WorkerGroupFacade {

    @PersistenceContext
    EntityManager entityManager;

    public List<WorkerGroup> GetAllGroups() {

        TypedQuery<WorkerGroup> query = entityManager.createNamedQuery("group.getall", WorkerGroup.class);
        return query.getResultList();
    }
}
