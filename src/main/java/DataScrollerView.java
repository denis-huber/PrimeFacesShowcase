/**
 * Created by Denis on 15.12.2016.
 */

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class DataScrollerView implements Serializable {


    @Inject
    private CarService service;

    public List<Car> getCars() {
        return service.getCars();
    }

    public void setService(CarService service) {
        this.service = service;
    }
}