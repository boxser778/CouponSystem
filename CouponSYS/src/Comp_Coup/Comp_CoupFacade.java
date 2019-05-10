package Comp_Coup;

import java.util.Set;

public class Comp_CoupFacade {

	private Comp_CoupDBDAO comp_coupDAO = new Comp_CoupDBDAO();
	private Comp_Coup comp_coup;

	public Comp_CoupFacade(Comp_Coup CompC) {
		this.comp_coup = CompC;
	}

	public Comp_CoupFacade() {
	
	}

	public void insertComp_Coup(Comp_Coup CompC) throws Exception {
		comp_coupDAO.insertComp_Coup(CompC);
	}

	public void removeComp_Coup(Comp_Coup CompC) throws Exception {
		comp_coupDAO.removeComp_Coup(CompC);
	}

	public void updateComp_Coup(Comp_Coup CompC, Long newCompanyId, Long newCouponId) throws Exception {
		CompC.setCompId(newCompanyId);
		CompC.setCoupId(newCouponId);
		CompC.updateComp_Coup(CompC);
	}

	public Comp_Coup getComp_Coup(int id) throws Exception {
		return comp_coupDAO.getComp_Coup(id);
	}

	public Set<Comp_Coup> getAllComp_Coup() throws Exception {

		return comp_coupDAO.getAllComp_Coup();

	}
	
}