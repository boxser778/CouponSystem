package Cust_Coup;

import java.util.Set;

public interface Cust_CoupDAO {

	void insertCust_Coup(Cust_Coup CustC) throws Exception;

	void removeCust_Coup(Cust_Coup CustC) throws Exception;

	void updateCust_Coup(Cust_Coup CustC) throws Exception;

	Cust_Coup getCust_Coup(long id) throws Exception;

	Set<Cust_Coup> getAllCust_Coup() throws Exception;
	
}