import java.time.LocalDate;
import java.time.Period;

public class DateDifference {
    public static void main(String[] args) {

        LocalDate d1 = LocalDate.of(2011, 6, 6);
        LocalDate d2 = LocalDate.of(2011, 7, 6);

        Period p = Period.between(d1, d2);

        if (p.getYears() == 0 &&
            p.getMonths() == 1 &&
            p.getDays() == 0) {
            System.out.println("Exactly one month apart");
        } else {
            System.out.println("Not exactly one month apart");
        }
    }
}
