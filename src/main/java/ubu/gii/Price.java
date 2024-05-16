package ubu.gii;

public abstract class Price {
	public abstract int getPriceCode();

	public abstract double getCharge(int daysRented);
	public abstract int frecuentPointCounter(int frequentRenterPoints, int daysRented);
}