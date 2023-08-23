import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    private double _amount = 0.0;
    private int _point = 0;

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        // add header lines
        String result = getHeadLines();

        // add content lines
        for (Rental each : _rentals) {
            //determine amounts for each line
            double thisAmount = each.getCharge();

            // add frequent renter points
            frequentRenterPoints += each.getPoint();

            // show figures for this rental
            result += getTitle(each.getMovie().getTitle(), thisAmount);

            totalAmount += thisAmount;
        }

        // add footer lines
        result += getFootLines(totalAmount, frequentRenterPoints);

        return result;
    }

    private String getTitle(String title, double thisAmount) {
        return "\t" + title + "\t" + String.valueOf(thisAmount) + "\n";
    }

    private String getFootLines(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + String.valueOf(totalAmount) + "\n" + "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    }

    private String getHeadLines() {
        return "Rental Record for " + getName() + "\n";
    }
}
