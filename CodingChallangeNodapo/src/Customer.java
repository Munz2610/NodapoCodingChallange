import java.util.ArrayList;
import java.util.List;

/*
 * Klasse Repräsentiert Kunden, welche über das Infocenter bei verschiedenen Shops einkaufen können.
 */
public class Customer {
	
	private String _name;
	private List<Book> _books;
	private int _money;		//Geldbetrag in eurocent
	
	public Customer(String name)
	{
		_name = name;
		_money = 0;
		_books = new ArrayList<Book>(0);
	}
	
	public String getName()
	{
		return _name;
	}
	
	public List<Book> getBooks()
	{
		return _books;
	}
	
	public int getMoney()
	{
		return _money;
	}
	
	public void buyBook(Book book)
	{
		_money -= book.getPrice();
		_books.add(book);
	}
	
	
	/*
	 * Bucht den Geldbetrag auf das Konto des Customers.
	 * 
	 * @require istPositiveMoney(money)
	 */
	public void earnMoney(int money)throws Exception
	{
		if(! isPositiveMoney(money))
		{
			throw new Exception("Money amount must be positive and grater then 0");
		}
		else
		{
			_money +=money;
		}
	}
	
	/*
	 * @return if Money is positive or negative
	 */
	static public boolean isPositiveMoney(int money)
	{
		if(money<1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean hasEnoughtMoney(Book book)
	{
		return (_money >= book.getPrice());
	}
	
}
