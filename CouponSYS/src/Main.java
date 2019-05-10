import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.time.LocalDate;

import Comp_Coup.Comp_Coup;
import Comp_Coup.Comp_CoupDB;
import Comp_Coup.Comp_CoupFacade;
import Company.Company;
import Company.CompanyFacade;
import Company.DatabaseCom;
import Coupon.Coupon;
import Coupon.CouponFacade;
import Coupon.DatabaseCou;
import Coupon.couponType;
import Cust_Coup.Cust_Coup;
import Cust_Coup.Cust_CoupDB;
import Cust_Coup.Cust_CoupFacade;
import Customer.Customer;
import Customer.CustomerFacade;
import Customer.DatabaseCus;
import Login.AdminFacade;
import Login.ClientType;
import Login.CouponClientFacade;

public class Main {

	public static void main(String[] args) throws Exception {

		
		String email = "kobi@gmail.com";
		String password="123456789";
		ClientType clientType= ClientType.Admin;
		
		
		CouponClientFacade client;
		AdminFacade adminFacade;
		
		
		
		
		
		
		// Student st1 = new Student(123,
		// Date.valueOf(LocalDate.now()),
		// Date.valueOf(LocalDate.now().plusDays(7).plusMonths(2).plusYears(5)));

		/** the direction of the Database **/

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		/** driver connection for JDBC **/

		Connection con = DriverManager.getConnection(DatabaseCom.getDBUrl());

		/** create table **/

		// DatabaseCom.createTables(con);
		// DatabaseCus.createTables(con);
		// DatabaseCou.createTables(con);
		// Comp_CoupDB.createTable(con);
		// Cust_CoupDB.createTable(con);

		/** call a Facade from the specific table **/

		CompanyFacade companyFacade = new CompanyFacade();
		CustomerFacade customerFacade = new CustomerFacade();
		CouponFacade couponFacade = new CouponFacade();
		Comp_CoupFacade comp_coupFacade = new Comp_CoupFacade();
		Cust_CoupFacade cust_coupFacade = new Cust_CoupFacade();

		/** insert into Table Companies single company by id,password,email **/

		// Company c1 = new Company(1, "Lala", "774589","Lala@yahoo.com");
		// companyFacade.insertCompany(c1);

		/**
		 * insert into Table Customers single customer by
		 * id,CustomerName,CustomerPassword
		 **/

		// Customer cust1 = new Customer(1, "Ran", "532879");
		// customerFacade.insertCustomer(cust1);

		/**
		 * insert into Table Coupons single coupon = id,Title,amount of Coupons,start
		 * date of the coupon,end date of the coupon,type of coupon(enum),short massage
		 * about the coupon,price of the coupon,image link that illustrate the coupon
		 **/

//		 Coupon coup1 = new Coupon(1,"40% in Fox",3,Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(7)),couponType.clothing.toString(),"40% off the T-shirts ends up in 1 week", 33.50,"");
//		 couponFacade.insertCoupon(coup1);

		/** remove (company,coupon,customer from the table) **/

		// companyFacade.removeCompany(c1);
		// couponFacade.removeCoupon(c1);
		// customerFacade.removeCustomer(c1);
		// comp_coupFacade.removeCust_Coup(null);
		// cust_coupFacade.removeComp_Coup(null);

		/** drop table **/

		// DatabaseCom.dropTable(con);
		// DatabaseCus.dropTable(con);
		// DatabaseCou.dropTable(con);
		// Cust_CoupDB.dropTable(con);
		// Comp_CoupDB.dropTable(con);

		/**
		 * get all the Database information about the choose table
		 * (companies,customers,coupons)
		 **/

		// System.out.println(companyFacade.getAllCompanies());
		// System.out.println(customerFacade.getAllCustomers());
		// System.out.println(couponFacade.getAllCoupons());
		// System.out.println(comp_coupFacade.getAllComp_Coup());
		// System.out.println(cust_coupFacade.getAllCust_Coup());

		/** add by 2 id parameters an object into Compt_Coup table **/

		// Comp_Coup CompC1 = new Comp_Coup(1,1);
		// comp_coupFacade.insertComp_Coup(CompC1);

		/** add by 2 id parameters an object into Cust_Coup table **/

		// Cust_Coup CustC1 = new Cust_Coup(1, 1);
		// cust_coupFacade.insertCust_Coup(CustC1);

		// ConnectionPool.getConnection();
		// ConnectionPool.returnConnection();
		// ConnectionPool.closeAllConnection();

		// thread test

//		 CouponExpDate exDate = new CouponExpDate();
//		 Thread t1 = new Thread(new CouponExpDate());
//		 t1.start();

		
			
	}
}
