package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Coupon.Coupon;
import Coupon.couponType;

public class CustomerFacade {

	Connection con;

	CustomerFacade() {

	}

	public void PurchaseCoupon(Coupon coupon) {

	}

	public void getAllPurchasedCoupons() {

	}

	public synchronized Set<Coupon> getAllPurchasedCouponByType(String couponType) throws Exception {
		con = DriverManager.getConnection("jdbc:derby://localhost:3305/JBDB;create=true");
		Set<Coupon> set = new HashSet<>();
		String sql = "SELECT * FROM Coupons WHERE type =" + couponType.toString();
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long id = rs.getLong(1);
				String title = rs.getString(2);
				int amount = rs.getInt(3);
				Date date = rs.getDate(4);
				Date localDate = rs.getDate(5);
				String type = rs.getString(6);
				String msg = rs.getString(7);
				Double price = rs.getDouble(8);
				String picture = rs.getString(9);

				set.add(new Coupon(id, title, amount, date, localDate, type, msg, price, picture));
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Coupon data");
		} finally {
			con.close();
		}
		return set;
	}

	public void getAllPurchasedCouponByPrice(double price) {

	}

}