package tw.ispan.springdemo.model;

import java.util.HashMap;

public class BookBeanStaticFactory {
	
	private static HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();
	
	static {
		bookMap.put(1, new Book(1, "learn java"));
		bookMap.put(2, new Book(2, "learn math"));
	}
	
	public static Book getBook(Integer key) {
		return bookMap.get(key);
	}


}