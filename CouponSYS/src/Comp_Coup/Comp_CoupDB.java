package Comp_Coup;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Comp_CoupDB {

	public static String getDriverData() {
		return "org.apache.derby.jdbc.ClientDriver";
	}

	public static String getDBUrl() {
		return "jdbc:derby://localhost:3305/JBDB;create=true";
	}

	public static void createTable(Connection con) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			String sql;

			{
				sql = "CREATE TABLE Comp_Coup(comp_id NOT NULL, coup_id NOT NULL,PRIMARY KEY(comp_id,coup_id) FORIGEN KEY comp_id REFERENCE companies (comp_id),FOREGIN KEY coup_id REFERENCE coupons(coup_id))";

				// System.out.println(sql);

				stmt.executeUpdate(sql);
				System.out.println("success:" + sql);
			}

		} catch (SQLException e) {

			System.out.println(e);
			System.out.println("Table are already exist");
		}
	}

	public static void dropTable(Connection con) throws SQLException {

		try {

			Statement stmt = con.createStatement();
			String sql;
			System.out.println("success to connect");
			{
				sql = " DROP TABLE Comp_Coup";

				stmt.executeUpdate(sql);
				System.out.println("success:" + sql);
			}

		} catch (SQLException e) {
			System.out.println(" Failed to Delete");
		}
	}

}
