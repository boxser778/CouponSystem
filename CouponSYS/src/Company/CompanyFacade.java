package Company;

import java.util.Set;

public class CompanyFacade {

	private CompanyDBDAO compDAO = new CompanyDBDAO();
	private Company company;

	public CompanyFacade(Company Comp) {
		this.company = Comp;
	}

	public CompanyFacade() {

	}

	public void insertCompany(Company company) throws Exception {
		compDAO.insertCompany(company);
	}

	public void removeCompany(Company company) throws Exception {
		compDAO.removeCompany(company);
	}

	public void updateCompany(Company company, String newcomp_Name, String newPassword, String newEmail)
			throws Exception {

		company.setComp_Name(newcomp_Name);
		company.setPassword(newPassword);
		company.setEmail(newEmail);
		compDAO.updateCompany(company);
	}

	public Company getCompany(int id) throws Exception {
		return compDAO.getCompany(id);
	}

	public Set<Company> getAllCompanies() throws Exception {

		return compDAO.getAllCompanies();

	}
}