

import java.util.Comparator;

import javax.print.DocFlavor.CHAR_ARRAY;



/*
 *Klasse Buch definiert das Material Buch 
 */
public class Book implements Comparable<Book> {
	
	private String _title;
	private int _price; 	//Geldbetrag in Eurocents
	private int _pageCount;
	private String _genre;
	private String _ISBN;
	
	public Book( String title, int price, int pageCount, String genre, String ISBN) throws Exception
	{
		if(!isCorrectPrice(price))
		{
			throw new Exception("price must be greater then 0");
		}
		if(!isCorrectGenre(genre))
		{
			throw new Exception("genre is not a valid genre");
		}
		if(!isCorrectISBN(ISBN))
		{
			throw new Exception("isbn is not a correct ISBN-13 Number");
		}
		_title = title;
		_price = price;
		_pageCount = pageCount;
		_genre = genre;
		_ISBN = ISBN;
	}
	
	
	public String getTitel()
	{
		return _title;
	}
	
	public int getPrice()
	{
		return _price;
	}
	
	public int getPageCount()
	{
		return _pageCount;
	}
	
	public String getGenre()
	{
		return _genre;
	}
	
	/*
	 * setzt den Preis des Buches auf einen neuen wert
	 * 
	 * @require isCorrectPrice(newPrice)
	 * 
	 */
	public void setPrice(int newPrice) throws Exception
	{
		if(!isCorrectPrice(newPrice))
		{
			throw new Exception("price must be greater then 0");
		}
		_price = newPrice;
	}
	
	/*
	 * Kontrolliert ob der übergebene String ein zulässiges Genre ist
	 */
	static public boolean isCorrectGenre(String genre)
	{
		if(genre == "Adventure" || genre == "Biography" || genre == "Comic" || genre == "Fantasy")
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/*
	 * Kontrolliert ob der übergebene String einer gültigen ISBN Nummer entspricht
	 */
	static public boolean isCorrectISBN(String ISBN)
	{
		if(ISBN.length() != 14)
		{
			return false;
		}
		else if(!(ISBN.charAt(3) == '-'))
		{
			return false;
		}
		else
		{
			ISBN = ISBN.substring(0, 3) + ISBN.substring(4);	//drittes Element also "-" raus nehmen 
		}
		
		int summe = 0;
		
		
		
		for(int i = 0; i <= 12; i++ )
		{
			if(ISBN.charAt(i) == '-')
			{
				//do nothing
			}
			else if(!Character.isDigit(ISBN.charAt(i)))
			{
				return false;
			}
			else
			{
				if(i == 0| i % 2 == 0)
				{
					summe += ISBN.charAt(i);
				}
				else
				{
					summe += ISBN.charAt(i)*3;
					
				}
			}
		}
		return (summe % 10 ==0 );
	}
	
	/*
	 * Kontrolliert, dass der Preis in Eurocents nicht negativ ist
	 */
	static public boolean isCorrectPrice(int price)
	{
		if(price < 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/*
	 * Bücher sind gleich sobald sie den selben Titel besitzen
	 */
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Book)
		{
			return _title.equals(((Book) o).getTitel());
		}
		else
		{
			return false;
		}
	}
	

	@Override
	public int compareTo(Book o) 
	{
		return _title.compareTo(o.getTitel());
	}
	
	
	

}
