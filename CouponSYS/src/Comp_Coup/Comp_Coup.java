package Comp_Coup;

public class Comp_Coup {

	private long compId;
	private long coupId;
	
	public Comp_Coup(long compId, long coupId) {
		
		this.compId = compId;
		this.coupId = coupId;
	}

	public long getCompId() {
		return compId;
	}

	public void setCompId(long compId) {
		this.compId = compId;
	}

	public long getCoupId() {
		return coupId;
	}

	public void setCoupId(long coupId) {
		this.coupId = coupId;
	}

	@Override
	public String toString() {
		return "Comp_Coup [compId=" + compId + ", coupId=" + coupId + "]";
	}

	public void updateComp_Coup(Comp_Coup compC) {
		// TODO Auto-generated method stub
		
	}
	
	
}