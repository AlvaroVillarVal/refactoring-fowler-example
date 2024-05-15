package ubu.gii;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		boolean html = false;
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			// determine amounts for each line
			thisAmount = each.getCharge();
		
			frequentRenterPoints = each.frecuentPointCounter(frequentRenterPoints);
			// show figures for this rental
			result += each.showFigures(thisAmount, html);
			totalAmount += thisAmount;
		}
		// add footer lines
		result += addFooter(totalAmount, frequentRenterPoints, html);
		return result;
	}

	public String htmlStatement() {
		boolean html = true;
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "<h1>Rental Record for " + getName() + "</h1>";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			// determine amounts for each line
			thisAmount = each.getCharge();

			frequentRenterPoints = each.frecuentPointCounter(frequentRenterPoints);
			// show figures for this rental
			result += each.showFigures(thisAmount, html);
			totalAmount += thisAmount;
		}
		// add footer lines
		result += addFooter(totalAmount, frequentRenterPoints, html);
		return result;
	}

	private String addFooter(double totalAmount, int frequentRenterPoints, boolean html) {
		String result = "";
		if (html) {
			result += "<p>Amount owed is " + String.valueOf(totalAmount) + "<br>";
			result += "You earned " + String.valueOf(frequentRenterPoints)
					+ " frequent renter points</p>";
			return result;
		}
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}
	
	
}
