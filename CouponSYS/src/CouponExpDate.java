import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import Coupon.Coupon;
import Coupon.CouponDBDAO;

public class CouponExpDate implements Runnable {

	boolean flag = true;
	CouponDBDAO myDBDAO = new CouponDBDAO();

	@Override
	public void run() {
		while (flag) {
//			System.out.println("hlo");
			try {
				Set<Coupon> myCoupons = myDBDAO.getAllCoupons();
				for (Coupon coupon : myCoupons) {
					if (coupon.getEndDate().before(Date.valueOf(LocalDate.now()))) {
						myDBDAO.removeCoupon(coupon);
					}
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			try {
				Thread.sleep(24*60*60*1000);  // 1000
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}