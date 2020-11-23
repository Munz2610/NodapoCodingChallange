/*
 * Testklasse für Book
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BookTest {
	
	
	@Test
	public void testConstructor() throws Exception
	{
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		Book book4 = new Book("Gregs Tagebuch",500,150,"Fantasy","978-3608963762");
		
		assertTrue(book1.getTitel().equals("Sonnenschein"));
		assertTrue(book2.getPrice() == 3020);
		assertTrue(book3.getPageCount() == 35899); 	
		assertTrue(book4.getGenre() == "Fantasy");
	}
	
	@Test
	public void testSetPrice() throws Exception	//TODO price
	{
		Book book1 = new Book("Halbblutritter",1020,289,"Adventure","978-3608963762");
		Book book2 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		
		book1.setPrice(1071);
		book2.setPrice(1000);
		
		assertTrue(book1.getPrice() == 1071);
		assertTrue(book2.getPrice() == 1000);
	}
	
	@Test
	public void testIsCorrectGenre()
	{
		assertTrue(Book.isCorrectGenre("Adventure"));
		assertTrue(Book.isCorrectGenre("Biography"));
		assertTrue(Book.isCorrectGenre("Comic"));
		assertTrue(Book.isCorrectGenre("Fantasy"));
		
		assertFalse(Book.isCorrectGenre("abcd"));
		assertFalse(Book.isCorrectGenre("Action"));
		assertFalse(Book.isCorrectGenre(""));		
	}
	
	@Test(expected = Exception.class)
	public void testGenreException() throws Exception
	{
		Book book7 = new Book("Exception",545,1020,"Action","978-3608963762");
	}
	
	@Test
	public void testIsCorrectISBN()
	{
		assertTrue(Book.isCorrectISBN("978-3608963762"));
		assertTrue(Book.isCorrectISBN("978-3442267743"));
		assertTrue(Book.isCorrectISBN("978-3841335180"));
		
		assertFalse(Book.isCorrectISBN(""));
		assertFalse(Book.isCorrectISBN("215-4356798546"));
		assertFalse(Book.isCorrectISBN("2154613164646141641"));
		assertFalse(Book.isCorrectISBN("152"));
		assertFalse(Book.isCorrectISBN("isbn"));
	}
	
	@Test(expected = Exception.class)
	public void testISBNException() throws Exception
	{
		Book book8 = new Book("Exception",545,1020,"Fantasy","978-36089637");
	}
	
	@Test
	public void testIsCorrectPrice()
	{
		assertTrue(Book.isCorrectPrice(123));
		assertTrue(Book.isCorrectPrice(20));
		assertTrue(Book.isCorrectPrice(5));
		assertTrue(Book.isCorrectPrice(100526));
		assertTrue(Book.isCorrectPrice(0));
		
		assertFalse(Book.isCorrectPrice(-1));
		assertFalse(Book.isCorrectPrice(-125));
		
	}
	
	@Test(expected = Exception.class)
	public void testPriceException() throws Exception
	{
		Book book9 = new Book("Exception",-10,1020,"Fantasy","978-3608963762");
	}
	
	@Test
	public void testEquals() throws Exception
	{
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		
		assertTrue(book1.equals(book3));
		assertTrue(book1.equals(book1));
		
		assertFalse(book1.equals(book2));
		assertFalse(book1.equals("Sonnenschein"));
	}
	
	@Test
	public void testCompare() throws Exception //Ich werde bei dieser Implementation auf etwas verzichten -> Siehe kommentar Book.compareTo()
	{
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		
		
		assertTrue(book1.compareTo(book1) == 0);
		assertTrue(book1.compareTo(book2) > 0);
		assertTrue(book2.compareTo(book1) < 0);
		
		
	}
	
}
