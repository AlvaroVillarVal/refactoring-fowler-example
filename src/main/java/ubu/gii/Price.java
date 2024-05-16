package ubu.gii;

public abstract class Price {
	public abstract int getPriceCode();

	public abstract double getCharge(int daysRented);

	protected int frecuentPointCounter(Movie movie, int frequentRenterPoints, int daysRented) {
		return frecuentPointCounter(frequentRenterPoints, daysRented);
	}

	protected int frecuentPointCounter(int frequentRenterPoints, int daysRented) {	
		frequentRenterPoints++;
		if ((getPriceCode() == Movie.NEW_RELEASE)
				&& daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
}