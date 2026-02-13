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

1. list.stream()
.sorted(Comparator.reverseOrder())
.skip(1)
.limit(1);

2. list.stream()
.sorted(Comparator.comparing(Employee::getSal).reversed())
.limit(3);

3. list.stream()
.collect(Collectors.groupingBy(String::length,
		Collectors.counting())
		);

4. list.stream()
.collect(Collectors.toMap(Employee::getId, Employee::getName
		(existing, replacement) -> existing));

5. list.stream()
.filter(s -> s!= null)
.filter(s.matches("^[A]"))
.sorted(Comparator.reverseOrder())
.collect(Collectors.toList()); // 
//Corrected
list.stream()
 .filter(Objects::nonNull)
 .filter(s -> s.startsWith("A"))
 .sorted(Comparator.reverseOrder())
 .collect(Collectors.toList());


6. list.stream()
.collect(Collectors.toMap())

5. 