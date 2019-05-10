package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Company.Company;
import Coupon.CouponDBDAO;
import Customer.Customer;
import Customer.CustomerDBDAO;

public class AdminFacade implements CouponClientFacade{

	CouponDBDAO couponDBDAO = new CouponDBDAO();
	CustomerDBDAO customerDBDAO = new CustomerDBDAO();
	

	AdminFacade() {

	}


	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {
		
		return null;
	}

}