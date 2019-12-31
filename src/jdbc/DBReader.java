package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

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
		//database metadata
		
			try {
				DatabaseMetaData dbmeta= con.getMetaData();
				System.out.println(dbmeta.toString());
				System.out.println(dbmeta.getDatabaseMajorVersion());
				System.out.println(dbmeta.getDatabaseProductName());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//3. create a statement object
		String sql="select First_name, last_name, employee_id from employees where last_name='King' ";
		try {
			Statement st= con.createStatement();
			//4. pass sql query string and execute statement
			ResultSet rs=st.executeQuery(sql);
			ResultSetMetaData rsmd= rs.getMetaData();
			int colCount= rsmd.getColumnCount();
			System.out.println(colCount);
			
			int colType= rsmd.getColumnType(3);
			System.out.println(colType);
			if(colType== Types.INTEGER) {
				System.out.println("col has integer type");
			}
			else if(colType== Types.VARCHAR) {
				System.out.println("col has type varchar");
			}
			else if(colType== Types.NUMERIC) {
				System.out.println("col is of type numeric");
			}
			
			System.out.println(rsmd.getColumnTypeName(3));
			while(rs.next()) {
				String fname=rs.getString(1);
				String lname=rs.getString(2);
				String id=rs.getString(3);
				System.out.println(id+" "+fname+" "+lname);
			}
			rs.close();
			st.close();
			con.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
