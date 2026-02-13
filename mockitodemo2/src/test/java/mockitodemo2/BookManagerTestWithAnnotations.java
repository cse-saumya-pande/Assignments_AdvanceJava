package mockitodemo2;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookManagerTestWithAnnotations {
	@Mock
	private BookDao bookDao;
	
	//inject the mocked one
	@InjectMocks
	private BookManager bookManager;
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetAllBooks(){
		List<Book>mockBooks = Arrays.asList(new Book(1, "effective java"), new Book(2, ""));
		
				
	}
	
	
}


