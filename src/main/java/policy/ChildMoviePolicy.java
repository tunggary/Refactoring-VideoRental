package policy;

public class ChildMoviePolicy implements MoviePolicy {
    @Override
    public double getCharge(int daysRented) {

        return 1.5 + (daysRented > 3 ? (daysRented - 3) * 1.5 : 0);
    }

    @Override
    public int getPoint(int daysRented) {
        return 1;
    }
}
