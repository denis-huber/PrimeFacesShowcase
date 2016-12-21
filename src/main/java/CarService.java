/**
 * Created by Denis on 15.12.2016.
 */

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

@Singleton
public class CarService {

    private final static String[] colors;

    private final static String[] brands;

    @PersistenceContext(unitName = "CarUnit")
    private EntityManager entityManager;


    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

        brands = new String[10];
        brands[0] = "BMW";
        brands[1] = "Mercedes";
        brands[2] = "Volvo";
        brands[3] = "Audi";
        brands[4] = "Renault";
        brands[5] = "Fiat";
        brands[6] = "Volkswagen";
        brands[7] = "Honda";
        brands[8] = "Jaguar";
        brands[9] = "Ford";
    }

    private final static int SIZE = 100;

    @PostConstruct
    public void init() {
        entityManager.createQuery("DELETE FROM Car c").executeUpdate();
        for (int i = 0; i < SIZE; i++) {
            Car c = new Car();
            c.setBrand(getRandomBrand());
            c.setYear(getRandomYear());
            c.setColor(getRandomColor());
            c.setPrice(getRandomPrice());
            c.setSoldState(getRandomSoldState());
            entityManager.persist(c);

        }
    }


    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomBrand() {
        return brands[(int) (Math.random() * 10)];
    }

    public int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    public boolean getRandomSoldState() {
        return (Math.random() > 0.5) ? true : false;
    }

    public List<String> getColors() {
        return Arrays.asList(colors);
    }

    public List<String> getBrands() {
        return Arrays.asList(brands);
    }

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
