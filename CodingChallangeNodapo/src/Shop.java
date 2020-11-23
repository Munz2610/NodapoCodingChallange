import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Ein Shop welcher Bücher verwaltet und verschiedene Informationen weiter geben kann.
 * 
 * Autor: Oliver Munz
 * 
 * 
 */

public class Shop {
	
	private String _name; 	//Name des Shops
	private int _sales; 	//Umsatz des Shops
	
	private List<Book> _books;
	
	/*
	 * Neuen Shop anhand eines Namens erstellen
	 */
	public Shop(String name)
	{
		_name= name;
		_sales = 0;
		_books = new ArrayList<Book>(0);
	}
	
	public String getName()
	{
		return _name;
	}
	
	public int getSales()
	{
		return _sales;
	}
	
	public List<Book> getListWithDuplicates()
	{
		return _books;
	}
	
	/*
	 * Neuen Umsatz buchen beim verkauf eines Buches
	 */
	private void bookSale(int newSale)
	{
		_sales += newSale;
	}
	
	/*
	 * Verkauft das durch den Namen gegebene Buch
	 * Bucht den Umsatz (bookSale)
	 * entfernt das Buch aus dem bestand (_books)
	 * 
	 * @require customer.hasEnoughtMoney(book) and this.hasBook(book)
	 */
	public void sellBook(Book book, Customer customer) throws Exception
	{
		if(!customer.hasEnoughtMoney(book))
		{
			throw new Exception("Customer has not enought Money");
		}
		if(!hasBook(book))
		{
			throw new Exception("This Book is not available in this Shop");
		}
		_books.remove(_books.indexOf(book));
		customer.buyBook(book);
		bookSale(book.getPrice());
	}
	
	public boolean hasBook(Book b)
	{
		return _books.contains(b);
	}
	
	/*
	 * Gibt die Bücher nach einem Gewissen Genre gefiltert aus
	 */
	public List<Book> getFilteredList(String genre)throws Exception
	{
		
		if(! Book.isCorrectGenre(genre))
		{
			throw new Exception("The given string is not a correct Genre");
		}
		
		List<Book> booksWithoutDuplicates = getListWithoutDuplicates();
		List<Book> filteredBooks = new ArrayList<Book>();
		
		for( int i = 0; i < booksWithoutDuplicates.size(); i++)
		{	
			if(booksWithoutDuplicates.get(i).getGenre().equals(genre))
			{
				filteredBooks.add(booksWithoutDuplicates.get(i));
			}
		}
			
		return filteredBooks;
	}
		
	/*
	 * Gibt die Bücherliste OHNE Duplikate zurück
	 */
	public List<Book> getListWithoutDuplicates()
	{
		
		List<Book> books = new ArrayList<Book>();
		
		for(int i = 0; i < _books.size() ; i ++ )
		{
			if(!(books.contains(_books.get(i))))
			{
				books.add(_books.get(i));
			}
		}
		
		return books;
	}
	
	public void addBook(Book book)
	{
		_books.add(book);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Shop)
		{
			List<Book> listShop1 = getListWithoutDuplicates();
			List<Book> listShop2 = ((Shop) o).getListWithoutDuplicates();
			
			if(listShop1.size() != listShop2.size())
			{
				return false;
			}
			
			Collections.sort(listShop1);
			Collections.sort(listShop2);
			
			return 	listShop1.equals(listShop2);
		}
		else
		{
			return false;
		}
		
	}
	
	
	
}
