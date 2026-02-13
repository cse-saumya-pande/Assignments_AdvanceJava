package junitAssignment1;

public class StudentService {
	public int calculateTotal(Student student) {
		return student.getMark1() + student.mark2 + student.getMark3() ;
	}
	
	public double calculateAverage(Student s) {
		int total = calculateTotal(s);
		return total/3.0;
	}
	
	public boolean isPassing(Student s) {
		return calculateAverage(s) >= 40.0;
	}
}
