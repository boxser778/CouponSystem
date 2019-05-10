package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class CompanyDBDAO {

	Connection con;

	public void insertCompany(Company company) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String sql = "INSERT INTO Companies (comp_name,password,email) VALUES(?,?,?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, company.getComp_Name());
			pstmt.setString(2, company.getPassword());
			pstmt.setString(3, company.getEmail());

			pstmt.executeUpdate();

			System.out.println("Company created. " + company.toString());
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("Company creation failed");
		} finally {
			con.close();
		}

	}

	public void removeCompany(Company company) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String pre1 = "DELETE FROM Companies WHERE id=?";

		try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, company.getId());
			pstm1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			throw new Exception("failed to remove company");
		} finally {
			con.close();
		}
	}

	public void updateCompany(Company company) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Company " + " SET password='" + company.getPassword() + "', email='"
					+ company.getEmail() + ",comp_name=" + company.getComp_Name() + "' WHERE ID=" + company.getId();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception("update Company failed");
		}
	}

	public Company getCompany(long id) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Company company = new Company();
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM Companies WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			company.setId(rs.getLong(1));
			company.setComp_Name(rs.getString(2));
			company.setPassword(rs.getString(3));
			company.setEmail(rs.getString(4));

		} catch (SQLException e) {
			throw new Exception("unable to get company data");
		} finally {
			con.close();
		}
		return company;
	}

	public synchronized Set<Company> getAllCompanies() throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Set<Company> set = new HashSet<>();
		String sql = "SELECT * FROM Companies";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long id = rs.getLong(1);
				String comp_name = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);

				set.add(new Company(id, comp_name, password, email));
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Company data");
		} finally {
			con.close();
		}
		return set;

	}

}
