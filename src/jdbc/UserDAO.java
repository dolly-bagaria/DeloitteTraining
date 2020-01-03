package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAO {
	Connection con= null;
	static List<User> users= new ArrayList<>();
	static List<Role> roles= new ArrayList<>();
	
	public UserDAO() {
		DBConnector connector= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection(); 
	}
	
	public void addUsersToList() {
		String sql="select u.id, u.name, u.username, u.password, u.email,u.role_id, r.name Role_Name,r.priv, u.mobile from users u,roles r where u.role_id=r.role_id";
		try {
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				Role r=new Role(rs.getInt(6),rs.getString(7),rs.getString(8));
				roles.add(r);
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),r, rs.getString(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printUserDetails() {
		Iterator<User> itr =users.iterator();
		System.out.println("Id\tName\tusername\t password\t email\trole\tmobile");
		while(itr.hasNext()) {
			User u=itr.next();
			System.out.println(u.getId()+"\t"+u.getName()+"\t"+u.getUsername()+" \t********** \t"+ u.getEmail()+"\t"+u.getRole().getName()+"\t"+ u.getMobile());
		}
	}
	
	public void printUserByRole(String n) {
		Iterator<User> iter =users.iterator();
		while(iter.hasNext()) {
			User u=iter.next();
			String name=u.getName();
			if(n.equalsIgnoreCase(name)) {
				String role= u.getRole().getName();
				System.out.println("role of "+n+ " is "+ role);
			}
		}
		
	}
	public static void main(String[] args) {
		
		UserDAO list= new UserDAO();
		System.out.println("===task 1===");
		list.addUsersToList();
		System.out.println("fetched user details");
		
		System.out.println("===task 2====");
		System.out.println("pring required user details");
		list.printUserDetails();
		
		System.out.println("===task 3===");
		System.out.println("printing role given user name");
		list.printUserByRole("Dolly");
	}

}
