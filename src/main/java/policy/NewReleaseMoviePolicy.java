package policy;

public class NewReleaseMoviePolicy implements MoviePolicy {
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getPoint(int daysRented) {
        return 1 + (daysRented > 1 ? 1 : 0);
    }
}
