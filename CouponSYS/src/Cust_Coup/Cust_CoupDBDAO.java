package Cust_Coup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class Cust_CoupDBDAO {

	Connection con;

	public void insertCust_Coup(Cust_Coup CustC) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String sql = "INSERT INTO Cust_Coup (CustId,CoupId) VALUES(?,?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setLong(1, CustC.getCustId());
			pstmt.setLong(2, CustC.getCoupId());

			pstmt.executeUpdate();

			System.out.println("object was added into Cust_Coup table. " + CustC.toString());
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("Cust_Coup insert failed");
		} finally {
			con.close();
		}

	}

	public void removeCust_Coup( Cust_Coup CustC) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String pre1 = "DELETE FROM Cust_Coup WHERE id=?";

		try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, CustC.getCustId());
			pstm1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			throw new Exception("failed to remove object from Cust_Coup");
		} finally {
			con.close();
		}
	}

	public void updateCust_Coup(Cust_Coup CustC) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Cust_Coup " + " SET CustId='" + CustC.getCustId() + "', CoupId='"
					+ CustC.getCoupId();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception("update Cust_Coup failed");
		}
	}

	public Cust_Coup getCust_Coup(long id) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Cust_Coup CustC = new Cust_Coup(id, id);
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM Cust_Coup WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			CustC.setCustId(rs.getLong(1));
			CustC.setCoupId(rs.getLong(2));
			

		} catch (SQLException e) {
			throw new Exception("unable to get Cust_Coup data");
		} finally {
			con.close();
		}
		return CustC;
	}

	public synchronized Set<Cust_Coup> getAllCust_Coup() throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Set<Cust_Coup> set = new HashSet<>();
		String sql = "SELECT * FROM Cust_Coup";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long CustomerId = rs.getLong(1);
				long CouponId = rs.getLong(2);
				

				set.add(new Cust_Coup(CustomerId, CouponId));
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Cust_Coup data");
		} finally {
			con.close();
		}
		return set;

	}
	
}
