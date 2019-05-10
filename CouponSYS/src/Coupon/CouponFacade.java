package Coupon;

import java.sql.Date;
import java.util.Set;

public class CouponFacade {

	private CouponDBDAO coupDAO = new CouponDBDAO();
	private Coupon coupon;

	public CouponFacade(Coupon C) {
		this.coupon = C;
	}

	public CouponFacade() {

	}

	public void insertCoupon(Coupon coupon) throws Exception {
		coupDAO.insertCoupon(coupon);
	}

	// remove Method use insert Method.
	public void removeCoupon(Coupon coupon) throws Exception {
		coupDAO.insertCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon, String newTitle, int newAmount, Date newstartDate, Date newendDate,
			String newMsg, double newPrice) throws Exception {
		coupon.setTitle(newTitle);
		coupon.setAmount(newAmount);
		coupon.setStartDate(newstartDate);
		coupon.setEndDate(newendDate);
		coupon.setMsg(newMsg);
		coupon.setPrice(newPrice);
		// coupon.setImage(newImage);

		coupDAO.updateCoupon(coupon);
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public Set<Coupon> getAllCoupons() throws Exception {

		return coupDAO.getAllCoupons();
	}

}