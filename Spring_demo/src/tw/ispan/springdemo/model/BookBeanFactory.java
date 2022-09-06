package tw.ispan.springdemo.model;

import java.util.HashMap;

public class BookBeanFactory {
	
	private HashMap<Integer, Book> bookmap = new HashMap<Integer, Book>();

	public BookBeanFactory() {
	}

	public HashMap<Integer, Book> getBookmap() {
		return bookmap;
	}

	public void setBookmap(HashMap<Integer, Book> bookmap) {
		this.bookmap = bookmap;
	}
	
	public Book getBook(Integer key) {
		return bookmap.get(key);
	}

}