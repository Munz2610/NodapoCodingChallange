/*
 * Testklasse für Book
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomerTest {
	
	
	@Test
	public void testConstructor() throws Exception
	{
		Customer customer1 = new Customer("Herbert");
		Customer customer2 = new Customer("Ursula");
		Customer customer3 = new Customer("Olaf");
		Customer customer4 = new Customer("Marie");
		Customer customer5 = new Customer("Helene");
		
		assertTrue(customer1.getMoney() == 0);
		assertTrue(customer3.getMoney() == 0);
		
		assertTrue(customer5.getBooks().size() == 0);
		assertTrue(customer2.getBooks().size() == 0);
		
		assertTrue(customer4.getName().equals("Marie"));
		assertTrue(customer3.getName().equals("Olaf"));
	}
	
	@Test
	public void testEarnMoney() throws Exception
	{
		Customer customer1 = new Customer("Herbert");
		Customer customer2 = new Customer("Olaf");
		Customer customer3 = new Customer("Helene");
		
		customer1.earnMoney(12356);
		customer2.earnMoney(250);
		customer3.earnMoney(10000);
		
		assertTrue(customer1.getMoney() == 12356);
		assertTrue(customer2.getMoney() == 250);
		assertTrue(customer3.getMoney() == 10000);
	}
	
	@Test
	public void testBuyBook() throws Exception
	{
		Customer customer1 = new Customer("Herbert");
		customer1.earnMoney(100000);
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Comic","978-3608963762");
		
		customer1.buyBook(book1);
		customer1.buyBook(book2);
		
		assertTrue(customer1.getBooks().size() == 2);
		
		assertTrue(customer1.getBooks().contains(book1));
		assertTrue(customer1.getBooks().contains(book2));
	}
	
	@Test
	public void testIsPositiveMoney()
	{
		assertTrue(Customer.isPositiveMoney(1));
		assertTrue(Customer.isPositiveMoney(20));
		assertTrue(Customer.isPositiveMoney(354));
		
		assertFalse(Customer.isPositiveMoney(0));
		assertFalse(Customer.isPositiveMoney(-1));
		assertFalse(Customer.isPositiveMoney(-856));
	}
	
	@Test(expected = Exception.class)
	public void testMoneyException() throws Exception
	{
		Customer customer1 = new Customer("Herbert");
		customer1.earnMoney(-159);
	}
	
	@Test
	public void testHasEnoughtMoney() throws Exception
	{
		Customer customer1 = new Customer("Herbert");
		Customer customer2 = new Customer("Ursula");
		
		customer1.earnMoney(3020);
		customer2.earnMoney(5098);
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		
		assertTrue(customer1.hasEnoughtMoney(book2));
		assertTrue(customer1.hasEnoughtMoney(book1));
		assertFalse(customer1.hasEnoughtMoney(book3));
		
		assertTrue(customer2.hasEnoughtMoney(book1));
		assertTrue(customer2.hasEnoughtMoney(book2));
		assertFalse(customer2.hasEnoughtMoney(book3));
	}

}
