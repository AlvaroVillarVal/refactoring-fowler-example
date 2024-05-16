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
		return _movie.getCharge(getDaysRented());
	}

	protected int frecuentPointCounter(int frequentRenterPoints) {
		return _movie.frecuentPointCounter(frequentRenterPoints, getDaysRented());
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
