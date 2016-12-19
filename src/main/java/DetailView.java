import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Denis on 15.12.2016.
 */
@Named
@RequestScoped
public class DetailView {

    private String id;
    private Car car;

    @Inject
    private CarService service;

    public void setService(CarService service) {
        this.service = service;
    }

    public String loadCar() {
        this.car = service.getCar(id);
        return "";
//        return car.getBrand() + "_" + car.getId();
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
