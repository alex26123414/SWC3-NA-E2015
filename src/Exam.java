
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Exam {

    private String name;
    private GregorianCalendar date;
    
    public Exam(String name, GregorianCalendar date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String niceDate = new SimpleDateFormat("dd. MMM").format(date.getTime());
        return name + " " + niceDate;
    }

}