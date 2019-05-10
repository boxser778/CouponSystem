package Customer;

public class Customer {
 
	private long id;
	private String customerName;
	private String customerPassword;
	
	public Customer(long id, String customerName, String customerPassword) {
		
		this.id = id;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
	}

	public Customer() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerPassword=" + customerPassword + "] \n\"";
	}
	
	
}