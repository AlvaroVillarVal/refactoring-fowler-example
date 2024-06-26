package ubu.gii;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ubu.gii.Customer;
import ubu.gii.Movie;
import ubu.gii.Rental;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1

 * 
 */
public class VideoClubTest {
	protected static Movie m0, m11, m12, m2,m3;
	protected static Customer c1;
	
	@BeforeAll
	public static void setUp() {
		m11 = new Movie("Sky Captain", 1);
		m12 = new Movie("Alejandro Magno", 1);
		m0 = new Movie("Accion Mutante", 0);
		m2 = new Movie("Hermano Oso", 2);
		m3=new Movie("DnD Honor entre ladrones",0);

		c1 = new Customer("Manuel");
	}

	@AfterAll
	public static void tearDown() throws Exception {}

	@Test
	public void testAlquiler() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);
		Rental r4 =new Rental(m3,8);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);
		c1.addRental(r4);

		String salida = c1.statement();
		System.out.println(salida);
		String salidaEsperada = new String("Rental Record for Manuel\n"
				+ "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
				+ "\tHermano Oso\t12.0\n" + "\tDnD Honor entre ladrones\t11.0\n"+"Amount owed is 40.0\n"
				+ "You earned 5 frequent renter points");

		assertTrue(salidaEsperada.equals(salida),"Calcula mal el alquiler");

	}



	
	@Test
	public void testHtmlStatement() {


		String salida = c1.htmlStatement();

		String salidaEsperada = new String("<h1>Rental Record for Manuel</h1>"
				+ "Sky Captain: 15.0<br>" + "Accion Mutante: 2.0<br>"
				+ "Hermano Oso: 12.0<br>" + "DnD Honor entre ladrones: 11.0<br>"+ "<p>Amount owed is 40.0<br>"
				+ "You earned 5 frequent renter points</p>");

		assertTrue(salidaEsperada.equals(salida),"Calcula mal el informe html");

	}

}
