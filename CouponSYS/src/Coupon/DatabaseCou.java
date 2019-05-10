package Coupon;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCou {

	public static String getDriverData() {
		return "org.apache.derby.jdbc.ClientDriver";
	}

	public static String getDBUrl() {
		return "jdbc:derby://localhost:3305/JBDB;create=true";
	}

	public static void createTables(Connection con) throws SQLException {

		try {

			Statement stmt = con.createStatement();
			String sql;
			{
				sql = " CREATE TABLE Coupons ("
						+ "id integer not null primary key generated always as identity(start with 1, increment by 1), "
						+ "title varchar(50) not null, " + "amount integer not null," + " startDate date not null ,"
						+ "endDate date not null, " + " type varchar(50) not null, " + "msg varchar(255) not null,"
						+ "price double not null, " + "picture varchar(250) not null)";

				stmt.executeUpdate(sql);
				System.out.println("success:" + sql);
			}
		} catch (SQLException e) {

			System.out.println(e);
			System.out.println("Tables are already exist");
		}
	}

	public static void dropTable(Connection con) throws SQLException {

		try {

			Statement stmt = con.createStatement();
			String sql;
			System.out.println("success to connect");
			{
				sql = " DROP TABLE Coupons";

				stmt.executeUpdate(sql);
				System.out.println("success:" + sql);
			}

		} catch (SQLException e) {
			System.out.println(" Failed to Delete");
		}
	}
}