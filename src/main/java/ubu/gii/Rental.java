package ubu.gii;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */
public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	protected double getCharge() {
		double thisAmount = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (getDaysRented() > 2)
				thisAmount += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (getDaysRented() > 3)
				thisAmount += (getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	protected int frecuentPointCounter(int frequentRenterPoints) {	
		frequentRenterPoints++;
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&& getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
	
	public String showFigures(double thisAmount, boolean html) {
		String result = "";
		if (html) {
			result += _movie.getTitle() + ": "
					+ String.valueOf(thisAmount) + "<br>";
			return result;
		}
		result += "\t" + _movie.getTitle() + "\t"
				+ String.valueOf(thisAmount) + "\n";
		return result;
	}

}
