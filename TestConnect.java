
import java.sql.*;

public class TestConnect {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://172.26.87.89:31770/mysql", "root", "password");
			Statement stmt = con.createStatement();
		      ResultSet rs = null;
		      DatabaseMetaData meta = (DatabaseMetaData) con.getMetaData();
		      rs = meta.getTables(null, null, null, new String[] {
		         "TABLE"
		      });
		      int count = 0;
		      System.out.println("All table names are in test database:");
		      while (rs.next()) {
		         String tblName = rs.getString("TABLE_NAME");
		         System.out.println(tblName);
		         count++;
		      }
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
