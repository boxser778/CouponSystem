package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class CustomerDBDAO {

	Connection con;	
	
	public void insertCustomer(Customer customer) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String sql = "INSERT INTO Customers (customerName,customerPassword)  VALUES(?,?)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, customer.getCustomerName());
			pstmt.setString(2, customer.getCustomerPassword());

			pstmt.executeUpdate();
			
			System.out.println("Customer created" + customer.toString());
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("Customer creation failed");
		} finally {
			con.close();
		}
	}

	public void removeCustomer(Customer customer) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String pre1 = "DELETE FROM Customers WHERE id=?";

		try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, customer.getId());
			pstm1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			throw new Exception("failed to remove customer");
		} finally {
			con.close();
		}
	}

	public void updateCustomer(Customer customer) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Customer " + " SET name='" + customer.getCustomerName() + "', Password='" + customer.getCustomerPassword()
					+ "' WHERE ID=" + customer.getId();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception("update Customer failed");
		}
	}

	public Customer getCustomer(long id) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Customer customer = new Customer();
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM Customers WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			customer.setId(rs.getLong(1));
			customer.setCustomerName(rs.getString(2));
			customer.setCustomerPassword(rs.getString(3));

		} catch (SQLException e) {
			throw new Exception("unable to get customer data");
		} finally {
			con.close();
		}
		return customer;
	}

	public synchronized Set<Customer> getAllCustomers() throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Set<Customer> set = new HashSet<>();
		String sql = "SELECT * FROM Customers";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long id = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				set.add(new Customer(id, name, password));
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Customer data");
		} finally {
			con.close();
		}
		return set;
	}
	
}