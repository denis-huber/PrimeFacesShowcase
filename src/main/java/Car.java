import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;

/**
 * Created by Denis on 15.12.2016.
 */

@Entity
@Table(name="Cars_Table")
@UuidGenerator(name="EMP_ID_GEN")
public class Car {

    @Id
    @GeneratedValue(generator="EMP_ID_GEN")
    private String id;
    private String brand;
    private int year_produced;
    private String color;
    private int price;
    private boolean soldState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year_produced;
    }

    public void setYear(int year) {
        this.year_produced = year;
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

}
