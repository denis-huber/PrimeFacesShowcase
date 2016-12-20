import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Denis on 19.12.2016.
 */
@Entity
@Table(name="Cars_Table")
public class CarsEntity {

    @Id
    private String id;
    private String brand;
//    private int year;
    private String color;
    private int price;
    private boolean soldState;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }

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


    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
