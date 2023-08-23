package policy;

public interface MoviePolicy {
    double getCharge(int daysRented);
    int getPoint(int daysRented);
}
