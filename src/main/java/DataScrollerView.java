/**
 * Created by Denis on 15.12.2016.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {


    @ManagedProperty("#{carService}")
    private CarService service;

    public List<Car> getCars() {
        return service.getCars();
    }

    public void setService(CarService service) {
        this.service = service;
    }
}