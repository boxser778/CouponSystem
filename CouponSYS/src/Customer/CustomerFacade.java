package Customer;

import java.util.Set;

public class CustomerFacade {

	private CustomerDBDAO custDAO = new CustomerDBDAO();
	private Customer customer;

	public CustomerFacade(Customer Cust) {
		this.customer = Cust;
	}

	public CustomerFacade( ) {
	}

	public void insertCustomer(Customer customer) throws Exception {
		custDAO.insertCustomer(customer);
		
	}
//remove Method use insert Method.
	public void removeCustomer(Customer customer) throws Exception {
		custDAO.insertCustomer(customer);
	}

	public void updateCustomer(Customer customer, String newName, String newPassword) throws Exception {
		customer.setCustomerName(newName);
		customer.setCustomerPassword(newPassword);
		custDAO.updateCustomer(customer);
	}

	public Customer getCustomer() {
		return customer;
	}

	public Set<Customer> getAllCustomers() throws Exception {
		
		return custDAO.getAllCustomers();
	}
	
}