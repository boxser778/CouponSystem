import Coupon.Coupon;

public class ConnectionPool {

	public static String getDriverData() {
		return "org.apache.derby.jdbc.ClientDriver";
	}

	public static String getDBUrl() {
		return "jdbc:derby://localhost:3305/JBDB;create=true";
	}
	
	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getConnectionPool() {

		return instance;
	}

	public static void getConnection() {

		return;
	}

	public static void returnConnection() {

		return;

	}

	public static void closeAllConnection() {

		return;
	}

}