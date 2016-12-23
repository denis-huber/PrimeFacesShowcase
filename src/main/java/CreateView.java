import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis on 22.12.2016.
 */
@Named
@ViewScoped
public class CreateView {

    private String brand;
    private int year_produced;
    private String color;
    private int price;
    private boolean soldState;
    private Map<String,String> brands;

    @Inject
    CarEJB carEJB;
    @Inject
    HitCounter hitCounter;

    @PostConstruct
    public void init() {
        brands = new HashMap();
        brands.put("BMW","BMW");
        brands.put("Mercedes","Mercedes");
        brands.put("Volvo","Volvo");
        brands.put("Volkswagen","Volkswagen");
        brands.put("Audi","Audi");
        brands.put("Renault","Renault");
        brands.put("Fiat","Fiat");
        brands.put("Honda","Honda");
        brands.put("Jaguar","Jaguar");
        brands.put("Ford","Ford");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear_produced() {
        return year_produced;
    }

    public void setYear_produced(int year_produced) {
        this.year_produced = year_produced;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSoldState() {
        return soldState;
    }

    public void setSoldState(boolean soldState) {
        this.soldState = soldState;
    }

    public Map<String, String> getBrands() {
        return brands;
    }

    public void setBrands(Map<String, String> brands) {
        this.brands = brands;
    }

    public void updateCar() {
        carEJB.createCar(brand,year_produced,color,price,soldState);
        hitCounter.increment();
    }

    public int getHits() {
        return hitCounter.getHits();
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Vielen Dank!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}


