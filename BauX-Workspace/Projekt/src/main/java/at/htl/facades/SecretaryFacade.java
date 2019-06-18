package at.htl.facades;

import at.htl.model.Secretary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class SecretaryFacade {

    @PersistenceContext
    EntityManager entityManager;

    public boolean validUser(String username, String password) {
        TypedQuery<Secretary> typedQuery =entityManager.createNamedQuery("secretary.findbyusername", Secretary.class);
        typedQuery.setParameter("username", username);
        Secretary sec = typedQuery.getSingleResult();

        if (sec.getPassword().equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }
}
