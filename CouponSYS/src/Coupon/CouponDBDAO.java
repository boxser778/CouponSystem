package Coupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CouponDBDAO {

	Connection con;

	public void insertCoupon(Coupon coupon) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String sql = "INSERT INTO Coupons (title,amount,startDate,endDate,type,msg,price,picture)  VALUES(?,?,?,?,?,?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, coupon.getTitle());
			pstmt.setInt(2, coupon.getAmount());
			pstmt.setDate(3, (java.sql.Date) coupon.getStartDate());
			pstmt.setDate(4, (java.sql.Date) coupon.getEndDate());
			pstmt.setString(5, coupon.getType());
			pstmt.setString(6, coupon.getMsg());
			pstmt.setDouble(7, coupon.getPrice());
			pstmt.setString(8, coupon.getPicture());

			pstmt.executeUpdate();
			System.out.println("Coupon created" + coupon.toString());
		} catch (SQLException e) {
			throw new Exception("Coupon creation failed");
		} finally {
			con.close();
		}
	}

	public void removeCoupon(Coupon coupon) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		String pre1 = "DELETE FROM Coupons WHERE id=?";

		try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, coupon.getId());
			pstm1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			throw new Exception("failed to remove coupon");
		} finally {
			con.close();
		}
	}

	public void updateCoupon(Coupon coupon) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Coupon " + " SET Title='" + coupon.getTitle() + "', Amount='" + coupon.getAmount()
					+ "', startDate='" + coupon.getStartDate() + "', endDate='" + coupon.getEndDate() + "',type="
					+ coupon.getType() + "',Msg= '" + coupon.getMsg() + "',Price='" + coupon.getPrice() + "'Picture= '"
					+ coupon.getPicture() + "' WHERE ID=" + coupon.getId();
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception("update Coupon failed");
		}
	}

	public Coupon getCoupon(long id) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Coupon coupon = new Coupon();
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM Coupons WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			coupon.setId(rs.getLong(1));
			coupon.setTitle(rs.getString(2));
			coupon.setAmount(rs.getInt(3));
			coupon.setStartDate(rs.getDate(4));
			coupon.setEndDate(rs.getDate(5));
			coupon.setType(rs.getString(6));
			coupon.setMsg(rs.getString(7));
			coupon.setPrice(rs.getDouble(8));
			coupon.setPicture(rs.getString(9));

		} catch (SQLException e) {
			throw new Exception("unable to get coupon data");
		} finally {
			con.close();
		}
		return coupon;
	}

	public synchronized Set<Coupon> getAllCoupons() throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Set<Coupon> set = new HashSet<>();
		String sql = "SELECT * FROM Coupons";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long id = rs.getLong(1);
				String title = rs.getString(2);
				int amount = rs.getInt(3);
				Date startDate = rs.getDate(4);
				Date endDate = rs.getDate(5);
				String type = rs.getString(6);
				String msg = rs.getString(7);
				Double price = rs.getDouble(8);
				String picture = rs.getString(9);

				set.add(new Coupon(id, title, amount, startDate, endDate, type, msg, price, picture));
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Coupon data");
		} finally {
			con.close();
		}
		return set;
	}

}