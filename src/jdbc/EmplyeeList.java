package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmplyeeList {
	
	Connection con= null;
	List<Employee> emps= new ArrayList<>();
	
	public EmplyeeList() {
		
	}
	
	public void listEmployeeByDept(String DeptName) {
		DBConnector connector= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		String sql="select * from employees where department_id in (select department_id from departments where department_name='"+DeptName+"')";
		try {
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listEmployeeByDept(int dept) {
		DBConnector connector= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		//String sql="select * from employees where department_id ="+ dept;
		String sql="select * from employees where department_id = ?";
		try {
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1,dept);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listEmployeeBeforeDate(String date) {
		DBConnector connector= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		String sql="select employee_id, first_name,last_name, department_id, salary,to_char(hire_date, 'DD-MON-YYYY') as hireDate from employees where hire_date < ?";
		try {
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setString(1,date);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String fname= rs.getString(2);
				String lname=rs.getString(3);
				int deptId=rs.getInt(4);
				double sal=rs.getDouble(5);
				String jdate=rs.getString(6);
				SimpleDateFormat sdf= new SimpleDateFormat("DD-MMM-YYYY");
				Date d = null;
				try {
					d = sdf.parse(jdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Employee e=new Employee(id, fname+" "+lname, deptId, d, sal);
				System.out.println(e);
				emps.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmplyeeList list=new EmplyeeList();
		
		System.out.println("====passing dept name====");
		list.listEmployeeByDept("Executive");
		
		System.out.println("====passing  dept id====");
		list.listEmployeeByDept(90);
		
		System.out.println("====passing  hire date====");
		list.listEmployeeBeforeDate("01-JAN-2010");
		
		System.out.println(list.emps.size() );
	}

}
