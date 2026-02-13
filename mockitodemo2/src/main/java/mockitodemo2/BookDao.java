package mockitodemo2;

import java.util.List;
import java.util.ArrayList;

public class BookDao {
	public  List<Book> getAllBooks(){
		return new ArrayList<>();
	}
	
	public boolean addBook(Book book) {
		return true;
	}
	
//	public boolean deleteBookById(int id) {
//		return true;
//	}
}
