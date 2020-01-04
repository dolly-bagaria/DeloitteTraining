package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Math;
public class EmpNameDisplayer {

	public static void main(String[] args) {
		
		dispalyName(182);
		getSalary("Lex");
	}
	
	public static void getSalary(String name) {
		Connection con= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection(); 
		String sql= "{call emp_sal(?,?)}";
		try {
			CallableStatement cst= con.prepareCall(sql);
			cst.setString(1,name);
			cst.registerOutParameter(2, Types.INTEGER);
			cst.execute();
				System.out.println("Salary of "+ name + " is ");
				System.out.println(cst.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void dispalyName(int id) {
		Connection con= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection(); 
		String sql= "{call emp_det(?,?,?)}";
		try {
			CallableStatement cst= con.prepareCall(sql);
			cst.setInt(1,id);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.registerOutParameter(3, Types.VARCHAR);
			boolean done = cst.execute();
				System.out.println(cst.getString(2));
				System.out.println(cst.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
