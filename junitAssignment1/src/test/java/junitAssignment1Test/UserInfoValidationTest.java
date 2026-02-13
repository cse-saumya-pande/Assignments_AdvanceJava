package junitAssignment1Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import junitAssignment1.UserInfoValidation;

public class UserInfoValidationTest {
	UserInfoValidation user;
	@BeforeEach
	void initialize() {
		user = new UserInfoValidation();
	}
	
	@Test
//	@ParameterizedTest
//	@CsvFileSource (resources = "/userPass.csv", numLinesToSkip = 1)
	void testPassword() {
		assertTrue(user.checkPassword("awd1212@"));
	}
	@ParameterizedTest
	@CsvFileSource (resources = "/userPass.csv", numLinesToSkip = 1)
	void testUsername(String username, String password) {
		assertTrue(user.checkUsername(username));
	}
	
	@ParameterizedTest
	@CsvFileSource (resources = "/userPass.csv", numLinesToSkip = 1)
    void testLoginSuccess(String username, String password) {
        assertTrue(user.canLogin(username, password));
    }
}
