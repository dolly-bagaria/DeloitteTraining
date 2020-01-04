package BookAssignment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jdbc.DBConnector;


public class UserDAO {
	Connection con= null;
	static List<Book> books= new ArrayList<>();
	static List<Author> authors= new ArrayList<>();
	static List<Publisher> publishers= new ArrayList<>();
	
	
	public UserDAO() {
		DBConnector connector= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection(); 
	}
	
	public void addToList() {
		String sql="select * from book b, author a, publisher p where b.author_id=a.author_id and b.publisher_id=p.publisher_id";
		try {
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				Author a= new Author(rs.getInt(8),rs.getString(9),rs.getString(10));
				authors.add(a);
				Publisher p= new Publisher(rs.getInt(11),rs.getString(12),rs.getString(13));
				publishers.add(p);
				Book b= new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),a,p);
				books.add(b);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listBooks() {
		Iterator<Book> itr =books.iterator();
		System.out.println("isbn\ttitle\tpages\tauthor name\tpublisher name\tcity");
		while(itr.hasNext()) {
			Book u=itr.next();
			System.out.println(u.getIsbn()+"\t"+u.getTitle()+"\t"+u.getPages()+"\t"+u.getAuthor().getName()+"\t"+u.getPublisher().getName()+"\t"+u.getPublisher().getCity());
		}
	}
	
	public void sortBooks() {
		String sql="select a.name, b.title from book b, author a where b.author_id=a.author_id order by a.name, b.title";
		try {
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			System.out.println("author name\t title");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void listBooksAfter(int x) {
		Iterator<Book> itr =books.iterator();
		System.out.println("books published after "+x+" are as follows:");
		while(itr.hasNext()) {
			Book u=itr.next();
			if(u.getPub_year()>x) {
				System.out.println(u.getTitle());
			}
		}
	}
	
	public void listByCity(String c) {
		Iterator<Book> iter =books.iterator();
		System.out.println("books of type poem in city:"+ c);
		while(iter.hasNext()) {
			Book u=iter.next();
			if(u.getType().equalsIgnoreCase("poems") && (u.getPublisher().getCity()).equalsIgnoreCase("Delhi")) {
				System.out.println("book titles:");
				System.out.println(u.getTitle());
			}
		}
	}
	
	public void bookCount(String n) {
		Connection con= new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection(); 
		String sql= "{call book_cnt(?,?)}";
		try {
			CallableStatement cst= con.prepareCall(sql);
			cst.setString(1,n);
			cst.registerOutParameter(2, Types.INTEGER);
			cst.execute();
				System.out.println("count: ");
				System.out.println(cst.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		UserDAO obj=new UserDAO();
		System.out.println("====adding to list====");
		obj.addToList();
		System.out.println("===task 1===");
		System.out.println("listing the required data");
		obj.listBooks();
		System.out.println("===task 2===");
		obj.sortBooks();
		System.out.println("===task 3====");
		obj.listBooksAfter(2000);
		System.out.println("===task 4===");
		obj.listByCity("Delhi");
		System.out.println("===task 5===");
		obj.bookCount("Coleho");
	}

}
