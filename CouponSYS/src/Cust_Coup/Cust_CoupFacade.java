package Cust_Coup;

import java.util.Set;

public class Cust_CoupFacade {

	private Cust_CoupDBDAO cust_coupDAO = new Cust_CoupDBDAO();
	private Cust_Coup cust_coup;

	public Cust_CoupFacade(Cust_Coup CustC) {
		this.cust_coup = CustC;
	}

	public Cust_CoupFacade() {

	}

	public void insertCust_Coup(Cust_Coup CustC) throws Exception {
		cust_coupDAO.insertCust_Coup(CustC);
	}

	public void removeCust_Coup(Cust_Coup CustC) throws Exception {
		cust_coupDAO.removeCust_Coup(CustC);
	}

	public void updateCust_Coup(Cust_Coup CustC, Long newCustId, Long newCoupId) throws Exception {
		CustC.setCustId(newCustId);
		CustC.setCoupId(newCoupId);
		CustC.updateCust_Coup(CustC);
	}

	public Cust_Coup getCust_Coup(int id) throws Exception {
		return cust_coupDAO.getCust_Coup(id);
	}

	public Set<Cust_Coup> getAllCust_Coup() throws Exception {

		return cust_coupDAO.getAllCust_Coup();

	}

}