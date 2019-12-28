package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileRandomAccess {

	public static void main(String[] args) {
		RandomAccessFile raf=null;
		try {
			raf = new RandomAccessFile("D://myData/pass.txt","rw");
			raf.seek(16);
	         // print the line
	         System.out.println("" + raf.readLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}

}
