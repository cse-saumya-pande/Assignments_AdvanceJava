package mokitoDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	@Mock
	MathService mathService; //dependency 
	@InjectMocks
	Calculator calculator; //class under test
	
	@Test
	void addTest() {
		//arrange 
		when(mathService.add(10, 20)).thenReturn(30);
		//assert
		assertEquals(30, calculator.add(10, 20));
		//verify interaction
		verify(mathService).add(10, 20);
	}
	
}

