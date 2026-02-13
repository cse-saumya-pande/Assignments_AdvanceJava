package junitAssignment1;

public class UserInfoValidation {
	String username;
	String password;
	public UserInfoValidation() {
		// TODO Auto-generated constructor stub
	}
	
	public UserInfoValidation(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public boolean checkPassword(String pass) {
		if (pass == null)
			return false;
		if(pass.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$%*&!?]{8,}$"))
			return true;
		return false;
	}
	public boolean checkUsername(String username) {
		if(username == null)
			return false;
		if(username.matches("^[A-Za-z\\d]{5,15}$"))
			return true;
		return false;
	}
	
	public boolean canLogin(String username, String password) {
        return checkUsername(username) && checkPassword(password);
    }
}
