package jdbc;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	int id;
	String fullname;
	int deptId;
	Date joinDate;
	double salary;
	public Employee(int id, String fullname, int deptId, Date joinDate, double salary) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.deptId = deptId;
		this.joinDate = joinDate;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-YYYY");
		String d = null;
		d = sdf.format(joinDate);
		return "Employee [id=" + id + ", fullname=" + fullname + ", deptId=" + deptId + ", joinDate=" + d
				+ ", salary=" + salary + "]";
	}
	
	
}
