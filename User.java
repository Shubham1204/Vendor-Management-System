import java.io.Serializable;


public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String first_name;
	private String last_name;
	private String email;
	private String password;

	User(){ };
	
	User(String first_name, String last_name, String email, String password){
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}
	
	User(String first_name){
		this.first_name = first_name;
	}
	
	@Override
	public String toString() {
		return "First Name: " + first_name + "\nLast Name: " + last_name + "\nEmail: " + email + "\nPassword: " + password; 
	}
	
	
	public String First_Name() {
		return first_name;
	}
	
	public String Last_name() {
		return last_name;
	}
	
	public String Email() {
		return email;
	}
	
	public String Password() {
		return password;
	}
}