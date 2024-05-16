package ubu.gii;

public class ChildrenPrice extends Price{

	@Override
	public int getPriceCode() {
		
		return Movie.CHILDRENS;
	}

	public double getCharge(int daysRented) {
		double thisAmount = 0;
		
			thisAmount += 1.5;
			if (daysRented > 3)
				thisAmount += (daysRented - 3) * 1.5;
			return thisAmount;
	}


	public int frecuentPointCounter(int daysRented) {	
		
		return 1;
	}
	
}