import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Denis on 21.12.2016.
 */
@Stateless
public class CarEJB {

    @PersistenceContext(unitName = "CarUnit")
    private EntityManager entityManager;

    public Car getCar(final String searchId) {
        TypedQuery<Car> q = entityManager.createQuery("select c from Car c where c.id = :searchID", Car.class);
        q.setParameter("searchID", searchId);
        return q.getSingleResult();
    }

    public List<Car> getCars() {
        TypedQuery<Car> q = entityManager.createQuery("select c from Car c", Car.class);
        return q.getResultList();
    }

}
