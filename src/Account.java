
public class Account {
	
	private String username;
	private String password;
	private String address;
	private String telephoneNumber;
	private String email;
	private boolean isAdmin;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String username, String password, String address, String telephoneNumber, String email,
			boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
