package Comp_Coup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Company.Company;

public class Comp_CoupDBDAO {

	Connection con;

	public void insertComp_Coup(Comp_Coup CompC) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String sql = "INSERT INTO Comp_Coup (CompId,CoupId) VALUES(?,?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setLong(1, CompC.getCompId());
			pstmt.setLong(2, CompC.getCoupId());

			pstmt.executeUpdate();

			System.out.println("object was added into Comp_Coup table. " + CompC.toString());
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("Comp_Coup insert failed");
		} finally {
			con.close();
		}

	}

	public void removeComp_Coup(Comp_Coup CompC) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String pre1 = "DELETE FROM Comp_Coup WHERE id=?";

		try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, CompC.getCompId());
			pstm1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			throw new Exception("failed to remove object from Comp_Coup");
		} finally {
			con.close();
		}
	}

	public void updateComp_Coup(Comp_Coup CompC) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Comp_Coup " + " SET CompId='" + CompC.getCompId() + "', CoupId='" + CompC.getCoupId();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception("update Comp_Coup failed");
		}
	}

	public Comp_Coup getComp_Coup(long id) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Comp_Coup CompC = new Comp_Coup(id, id);
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM Comp_Coup WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			CompC.setCompId(rs.getLong(1));
			CompC.setCoupId(rs.getLong(2));

		} catch (SQLException e) {
			throw new Exception("unable to get Comp_Coup data");
		} finally {
			con.close();
		}
		return CompC;
	}

	public synchronized Set<Comp_Coup> getAllComp_Coup() throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Set<Comp_Coup> set = new HashSet<>();
		String sql = "SELECT * FROM Comp_Coup";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long CompanyId = rs.getLong(1);
				long CouponId = rs.getLong(2);

				set.add(new Comp_Coup(CompanyId, CouponId));
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Comp_Coup data");
		} finally {
			con.close();
		}
		return set;

	}

}