package ubu.gii;

public class NewReleasePrice extends Price{

	@Override
	public int getPriceCode() {
		
		return Movie.NEW_RELEASE;
	}

	public double getCharge(int daysRented) {
		double thisAmount = 0;
			thisAmount += daysRented * 3;
			
		return thisAmount;
	}

	public int frecuentPointCounter(int frequentRenterPoints, int daysRented) {	
		frequentRenterPoints++;
		if ((getPriceCode() == Movie.NEW_RELEASE)
				&& daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
	
}