package policy;

public class RegularMoviePolicy implements MoviePolicy {
    @Override
    public double getCharge(int daysRented) {
        return 2 + (daysRented > 2 ? (daysRented - 2) * 1.5 : 0);
    }

    @Override
    public int getPoint(int daysRented) {
        return 1;
    }
}
