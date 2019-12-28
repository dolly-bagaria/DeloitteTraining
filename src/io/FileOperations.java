package io;

import java.io.File;
import java.util.Date;

public class FileOperations {

	public static void main(String[] args) {
		File file= new File("D://myData");
		boolean done=file.mkdir();
		System.out.println(done);
		String[] files= file.list();
		System.out.println("===listing the files in myData===");
		for(String s: files) {
			System.out.println(s);
			
		}
		System.out.println("===printing file details===");
		PrintFiles(file);
	}
	
	public static void PrintFiles(File f) {
		String[] files= f.list();
		System.out.println("file Name\t last modified date\t length");
		System.out.println("--------------------------------------------------");
		for(String s: files) {
			File fi=new File(f.getPath()+"/"+s);
			System.out.println(fi.getName()+"\t"+new Date(fi.lastModified())+"\t"+fi.length());
			
		}
	}

}
