package Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCus {

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
				sql = " create table Customers ("
						+ "id integer not null primary key generated always as identity(start with 1, increment by 1), "
						+ "customerName varchar(50) not null, " + "customerPassword varchar(50) not null)";

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
					sql = " DROP TABLE Customers";

					stmt.executeUpdate(sql);
					System.out.println("success:" + sql);
				}

			} catch (SQLException e) {
				System.out.println(" Failed to Delete");
			}
	}
}
