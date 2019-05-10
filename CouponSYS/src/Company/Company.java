package Company;

public class Company {
	private long id;
	private String comp_name;
	private String password;
	private String email;

	public Company() {

	}

	public Company(long id, String comp_name, String password, String email) {

		setId(id);
		setComp_Name(comp_name);
		setPassword(password);
		setEmail(email);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComp_Name() {
		return comp_name;
	}

	public void setComp_Name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ",comp_name=" + comp_name + ", password=" + password + ", email=" + email
				+ "] \n\"";
	}

}