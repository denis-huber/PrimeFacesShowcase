import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by Denis on 15.12.2016.
 */
@Named
@RequestScoped
public class DetailView {

    private String id;
    private Car car;

    @EJB
    private CarEJB carEJB;

    public String loadCar() {
        this.car = carEJB.getCar(id);
        return "";
    }

    public Car getCar() {
        return car;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
