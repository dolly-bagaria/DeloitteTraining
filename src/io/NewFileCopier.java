package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.io.PrintStream;

public class NewFileCopier {

	public static void main(String[] args) {
		
		if(args.length < 2) {
			System.out.println("Usage: java fileCopier infile outfile");
		}
		else {
		String inFile= args[0];
		String outFile= args[1];
		
		//InputStream in;
		//OutputStream out;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(inFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream fout=null;
		PrintStream out =null;
		try {
			fout=new FileOutputStream(outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out= new PrintStream(fout);
		try {
			int bite=fis.read();
			while(bite != -1) {
				out.print((char)bite);
				bite=fis.read();
			}
			out.flush();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		}	
		
	}

}
