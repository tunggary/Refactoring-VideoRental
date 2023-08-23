import policy.MoviePolicy;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;

    private String _title;
    private int _priceCode;

    private MoviePolicy _policy;

    public Movie(String title, int priceCode, MoviePolicy policy) {
        _title = title;
        _priceCode = priceCode;
        _policy = policy;
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {
        return _policy.getCharge(daysRented);
    }

    public int getPoint(int daysRented) {
        return _policy.getPoint(daysRented);
    }
}
