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
            double thisAmount = getAmount(each.getMovie().getPriceCode(), each.getDaysRented());

            // add frequent renter points
            frequentRenterPoints += getPoint(each.getMovie().getPriceCode(), each.getDaysRented());

            // show figures for this rental
            result += getTitle(each.getMovie().getTitle(), thisAmount);

            totalAmount += thisAmount;
        }

        // add footer lines
        result += getFootLines(totalAmount, frequentRenterPoints);

        return result;
    }

    private static String getTitle(String title, double thisAmount) {
        return "\t" + title + "\t" + String.valueOf(thisAmount) + "\n";
    }

    private String getFootLines(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + String.valueOf(totalAmount) + "\n" + "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    }

    private String getHeadLines() {
        return "Rental Record for " + getName() + "\n";
    }

    private int getPoint(int priceCode, int daysRented) {
        return 1 + (priceCode == Movie.NEW_RELEASE && daysRented > 1 ? 1 : 0);
    }

    private double getAmount(int priceCode, int daysRented) {
        double thisAmount = 0.0;
        switch (priceCode) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
