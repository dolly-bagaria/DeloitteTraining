package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import collection.Student;
public class ObjectReader {

	public static void main(String[] args) {
		try {
			InputStream fis= new FileInputStream("std.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);
			Student st= (Student) ois.readObject();
			System.out.println(st);
			ois.close();
		} catch(IOException ioe) {
			System.out.println("object could not be read"+ ioe.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("class not found"+ e.getMessage());
			//e.printStackTrace();
		}
			

	}

}
