/*
 * Testklasse für Book
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class ShopTest {
	
	@Test
	public void testConstructor()
	{
		Shop shop1 = new Shop("BuchladenHelge");
		Shop shop2 = new Shop("BenesBuch");
		Shop shop3 = new Shop("Staatsbibliothek");
		
		assertTrue(shop1.getName().equals("BuchladenHelge"));
		assertTrue(shop3.getName().equals("Staatsbibliothek"));
		
		assertTrue(shop2.getSales() == 0);
		assertTrue(shop3.getSales() == 0);
		
		assertTrue(shop1.getListWithDuplicates().size() == 0);
		assertTrue(shop3.getListWithDuplicates().size() == 0);
		
	}
	
	@Test
	public void testAddBook() throws Exception
	{
		Shop shop1 = new Shop("Staatsbibliothek");
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		Book book4 = new Book("Gregs Tagebuch",500,150,"Fantasy","978-3608963762");
		Book book5 = new Book("Halbblutritter",1020,289,"Adventure","978-3608963762");
		Book book6 = new Book("Ab durch die Hecke",1298,387,"Adventure","978-3608963762");
		
		
		shop1.addBook(book1);
		shop1.addBook(book2);
		shop1.addBook(book3);
		shop1.addBook(book4);
		shop1.addBook(book5);
		shop1.addBook(book6);
		
		assertTrue(shop1.getListWithDuplicates().size() == 6);
			
		assertTrue(shop1.getListWithDuplicates().contains(book1));
		assertTrue(shop1.getListWithDuplicates().contains(book2));
		assertTrue(shop1.getListWithDuplicates().contains(book3));
		assertTrue(shop1.getListWithDuplicates().contains(book4));
		assertTrue(shop1.getListWithDuplicates().contains(book5));
		assertTrue(shop1.getListWithDuplicates().contains(book6));
		
	}
	
	@Test
	public void testGetListWithDuplicates() throws Exception
	{
		Shop shop1 = new Shop("Staatsbibliothek");
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		Book book4 = new Book("Gregs Tagebuch",500,150,"Fantasy","978-3608963762");
		Book book5 = new Book("Halbblutritter",1020,289,"Adventure","978-3608963762");
		Book book6 = new Book("Ab durch die Hecke",1298,387,"Adventure","978-3608963762");
		
		
		shop1.addBook(book1);
		shop1.addBook(book2);
		shop1.addBook(book2);
		shop1.addBook(book2);
		shop1.addBook(book2);	
		shop1.addBook(book3);
		shop1.addBook(book4);
		shop1.addBook(book5);
		shop1.addBook(book5);
		shop1.addBook(book6);
		shop1.addBook(book6);
		shop1.addBook(book6);
				
		List<Book> listShop1 = shop1.getListWithDuplicates();

		assertTrue(listShop1.size() == 12);
		
		assertTrue(listShop1.contains(book1));
		assertTrue(listShop1.contains(book2));
		assertTrue(listShop1.contains(book3));
		assertTrue(listShop1.contains(book4));
		assertTrue(listShop1.contains(book5));
		assertTrue(listShop1.contains(book6));
	}
	
	@Test
	public void testGetListWithoutDuplicates() throws Exception
	{
		Shop shop1 = new Shop("Staatsbibliothek");
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		Book book4 = new Book("Gregs Tagebuch",500,150,"Fantasy","978-3608963762");
		Book book5 = new Book("Halbblutritter",1020,289,"Adventure","978-3608963762");
		Book book6 = new Book("Ab durch die Hecke",1298,387,"Adventure","978-3608963762");
		
		
		shop1.addBook(book1);
		shop1.addBook(book2);
		shop1.addBook(book2);
		shop1.addBook(book2);
		shop1.addBook(book2);	
		shop1.addBook(book3);
		shop1.addBook(book4);
		shop1.addBook(book5);
		shop1.addBook(book5);
		shop1.addBook(book6);
		shop1.addBook(book6);
		shop1.addBook(book6);
				
		List<Book> listShop1 = shop1.getListWithoutDuplicates();

		assertTrue(listShop1.size() == 6);
		
		assertTrue(listShop1.contains(book1));
		assertTrue(listShop1.contains(book2));
		assertTrue(listShop1.contains(book3));
		assertTrue(listShop1.contains(book4));
		assertTrue(listShop1.contains(book5));
		assertTrue(listShop1.contains(book6));
	}
	
	@Test 
	public void testSellBook() throws Exception
	{
		Shop shop1 = new Shop("Staatsbibliothek");
		
		Customer customer1 = new Customer("Peter");
		
		customer1.earnMoney(8119);
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		Book book4 = new Book("Gregs Tagebuch",500,150,"Fantasy","978-3608963762");
		Book book5 = new Book("Halbblutritter",1020,289,"Adventure","978-3608963762");
		Book book6 = new Book("Ab durch die Hecke",1298,387,"Adventure","978-3608963762");
				
		shop1.addBook(book1);
		shop1.addBook(book2);
		shop1.addBook(book2);	
		shop1.addBook(book3);
		shop1.addBook(book4);
		shop1.addBook(book5);
		shop1.addBook(book6);
		
		shop1.sellBook(book2,customer1);
		shop1.sellBook(book3,customer1);
		
		assertTrue(shop1.getSales() == book2.getPrice() + book3.getPrice());
		
		List<Book> listShop1 = shop1.getListWithDuplicates();
		
		assertTrue(listShop1.size() == 5); 	//hat ursprünglich 7 Bücher 2 werden verkauft
		assertTrue(listShop1.contains(book2));
		assertFalse(listShop1.contains(book3));
		
		assertTrue(customer1.getBooks().contains(book2));
		assertTrue(customer1.getBooks().contains(book3));
		assertTrue(customer1.getMoney() == 0);
	}
	
	@Test(expected = Exception.class)
	public void testNoMoneyException() throws Exception
	{
		Shop shop1 = new Shop("Staatsbibliothek");
		
		Customer customer1 = new Customer("Peter");
		
		customer1.earnMoney(3019);
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
				
		shop1.addBook(book1);
		shop1.addBook(book2);
		shop1.addBook(book3);
		
		shop1.sellBook(book2,customer1);
	}
	
	@Test(expected = Exception.class)
	public void testNotExistingBookException() throws Exception
	{
		Shop shop1 = new Shop("Staatsbibliothek");
		
		Customer customer1 = new Customer("Peter");
		
		customer1.earnMoney(8119);
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
				
		shop1.addBook(book1);
		shop1.addBook(book2);
		
		shop1.sellBook(book3,customer1);
	}
	
	@Test
	public void testGetFilteredList() throws Exception
	{
		Shop shop1 = new Shop("Staatsbibliothek");
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		Book book4 = new Book("Gregs Tagebuch",500,150,"Fantasy","978-3608963762");
		Book book5 = new Book("Halbblutritter",1020,289,"Adventure","978-3608963762");
		Book book6 = new Book("Ab durch die Hecke",1298,387,"Adventure","978-3608963762");
				
		shop1.addBook(book1);
		shop1.addBook(book2);
		shop1.addBook(book2);
		shop1.addBook(book2);
		shop1.addBook(book2);	
		shop1.addBook(book3);
		shop1.addBook(book4);
		shop1.addBook(book5);
		shop1.addBook(book5);
		shop1.addBook(book6);
		shop1.addBook(book6);
		shop1.addBook(book6);
		
		List<Book> adventureList = shop1.getFilteredList("Adventure");
		List<Book> biographieList = shop1.getFilteredList("Biography");
		
		assertTrue(adventureList.size() == 3);
		assertTrue(biographieList.size() == 2);
		
		assertTrue(adventureList.contains(book1));
		assertTrue(adventureList.contains(book5));
		assertTrue(adventureList.contains(book6));
		
		assertTrue(biographieList.contains(book2));
		assertTrue(biographieList.contains(book3));
	}
	
	@Test
	public void testCompareShops() throws Exception
	{
		
		Shop shop1 = new Shop("Staatsbibliothek");
		Shop shop2 = new Shop("Buchladen");
		Shop shop3 = new Shop("Staatsbibliothek");
		
		Book book1 = new Book("Sonnenschein",250,100,"Adventure","978-3608963762");
		Book book2 = new Book("Lindenberg: Mach dein Ding",3020,345,"Biography","978-3608963762");
		Book book3 = new Book("Fünf Freunde und der Silberne Schatz",5099,35899,"Biography","978-3608963762");
		Book book4 = new Book("Gregs Tagebuch",500,150,"Fantasy","978-3608963762");
		Book book5 = new Book("Halbblutritter",1020,289,"Adventure","978-3608963762");
		Book book6 = new Book("Ab durch die Hecke",1298,387,"Adventure","978-3608963762");
		
		shop1.addBook(book6);
		shop1.addBook(book3);
		shop1.addBook(book2);
		
		shop2.addBook(book3);
		shop2.addBook(book4);
		shop2.addBook(book5);
		shop2.addBook(book1);
		
		shop3.addBook(book6);
		shop3.addBook(book6);
		shop3.addBook(book3);
		shop3.addBook(book2);
		
		assertFalse(shop1.equals(shop2));
		assertTrue(shop1.equals(shop1));	
		assertTrue(shop1.equals(shop3));
	}

}
