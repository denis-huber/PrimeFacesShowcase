import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Denis on 19.12.2016.
 */
@Path("/carressource")
public class CarRessource {

    @EJB
    CarEJB carEJB;

    @GET
    @Produces("application/json")
    public JsonArray getClichedMessage() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        List<Car> cars = carEJB.getCars();
        cars.forEach(car ->{
            builder.add(Json.createObjectBuilder().add("brand", car.getBrand()).add("year", car.getYear()));
        });
        return builder.build();
    }
}
