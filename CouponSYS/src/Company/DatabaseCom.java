package Company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCom {

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
				sql = "CREATE TABLE Companies("
						+ "id bigint not null primary key generated always as identity(start with 1, increment by 1), "
						+ "comp_name varchar(50) not null," + "password varchar(50) not null, "
						+ "email varchar(50) not null)";
				// System.out.println(sql);

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
				sql = " DROP TABLE Companies";

				stmt.executeUpdate(sql);
				System.out.println("success:" + sql);
			}

		} catch (SQLException e) {
			System.out.println(" Failed to Delete" + e);
		}
	}
}