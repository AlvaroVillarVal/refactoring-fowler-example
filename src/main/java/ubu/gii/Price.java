package ubu.gii;

public abstract class Price {
	public abstract int getPriceCode();

	protected double getCharge(Movie movie, int daysRented) {
		return getCharge(daysRented);
	}
	public abstract double getCharge(int daysRented);
}