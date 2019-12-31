package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeDetails {
	Connection con= null;
	static Map<String, String> map = new HashMap<>();
	
	
	public void listEmployeeByDate(String hireDate) {
		DBConnector connector= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		String sql="select employee_id,  to_char(hire_date, 'DD Month YYYY') as hiredate from employees where hire_date < ?";
		try {
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1,hireDate);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1),rs.getString(2));
				//System.out.println(rs.getString(1)+":  "+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDetails list=new EmployeeDetails();
		
		System.out.println("====passing hire date====");
		list.listEmployeeByDate("01-JAn-10");
		
		Set<String> set= map.keySet();
		
		
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()) {
			String key=itr.next();
			String value=map.get(key);
			System.out.println(key+": "+value);
		}
		System.out.println("no. of employees before the specified date: "+set.size());
	}
}
