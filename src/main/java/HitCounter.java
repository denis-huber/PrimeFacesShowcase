import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by Denis on 22.12.2016.
 */

@SessionScoped
public class HitCounter implements Serializable {
    private int hits;

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void increment() {
        ++this.hits;
    }
}
