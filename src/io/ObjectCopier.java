package io;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import collection.Student;

public class ObjectCopier {

	public static void main(String[] args) {
		Student st=new Student("Akash", 12345);  //student class needs to implement serializable
		try {
			FileOutputStream fout=new FileOutputStream("std.ser");
			ObjectOutputStream oos= new ObjectOutputStream(fout);
			oos.writeObject(st);
			oos.flush();
			oos.close();
			System.out.println("object serialized");
		} 
		catch(IOException ioe) {
			System.out.println("object failed to serialize");
			System.out.println(ioe.getMessage());
		}
	}

}
