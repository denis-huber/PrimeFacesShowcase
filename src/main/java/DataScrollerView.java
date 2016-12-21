/**
 * Created by Denis on 15.12.2016.
 */

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class DataScrollerView implements Serializable {

    @EJB
    CarEJB carEJB;

    public List<Car> getCars() {
        return carEJB.getCars();
    }

}

