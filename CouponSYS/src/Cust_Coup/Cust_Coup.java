package Cust_Coup;

public class Cust_Coup {

	private long custId;
	private long coupId;

	public Cust_Coup(long custId, long coupId) {
	
		this.custId = custId;
		this.coupId = coupId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getCoupId() {
		return coupId;
	}

	public void setCoupId(long coupId) {
		this.coupId = coupId;
	}

	@Override
	public String toString() {
		return "Cust_Coup [custId=" + custId + ", coupId=" + coupId + "]";
	}

	public void updateCust_Coup(Cust_Coup custC) {
		// TODO Auto-generated method stub
		
	}

}