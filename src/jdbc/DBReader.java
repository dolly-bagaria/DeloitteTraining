package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DBReader {

	public static void main(String[] args) {
		//load the driver
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("driver not found"+e.getMessage());
		}
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="hr";
		String password="hr";
		
	//2. get connection to the database
		try {
			con=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection failed"+e.getMessage());
		}
		//3. create a statement object
		String sql="select count(*) from departments ";
		try {
			Statement st= con.createStatement();
			//4. pass sql query string and execute statement
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString(1);
				System.out.println(id);
			}
			rs.close();
			st.close();
			con.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
