package Comp_Coup;

import java.util.Set;

public interface Comp_CoupDAO {

	void insertComp_Coup(Comp_Coup CompC) throws Exception;

	void removeComp_Coup(Comp_Coup CompC) throws Exception;

	void updateComp_Coup(Comp_Coup CompC) throws Exception;

	Comp_Coup getComp_Coup(long id) throws Exception;

	Set<Comp_Coup> getAllComp_Coup() throws Exception;

}
