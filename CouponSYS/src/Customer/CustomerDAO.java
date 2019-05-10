package Customer;

import java.util.Set;

public interface CustomerDAO {

	void insertCustomer(Customer customer) throws Exception;

	void removeCustomer(Customer customer) throws Exception;

	void updateCustomer(Customer customer) throws Exception;

	Customer getCustomer(long id) throws Exception;

	Set<Customer> getAllCustomers() throws Exception;

}