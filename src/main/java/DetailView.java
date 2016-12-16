import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Denis on 15.12.2016.
 */

@ManagedBean
@ViewScoped
public class DetailView {

    private String id;
    private Car car;

    @ManagedProperty("#{carService}")
    private CarService service;

    public void setService(CarService service) {
        this.service = service;
    }

    public String loadCar() {
        this.car = service.getCar(id);
        return car.getBrand() + "_" + car.getId();
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
