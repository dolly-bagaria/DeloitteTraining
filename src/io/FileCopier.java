package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopier {

	private static String filename="D://origin.txt";
	private static String filename2="D://destination.txt";
	public static void main(String[] args) {
		File file= new File(filename);
		boolean fileExists=file.exists();
		System.out.println("file available? " + file.exists());
		if(fileExists) {
			FileReader reader=null;
			BufferedReader buffer=null;
			
			//file reader
			try {
				reader= new FileReader(file);
			} catch (FileNotFoundException e) {
				System.out.println("File doesnot exist");
				e.printStackTrace();
				
			}
			//file writer
			FileWriter fw=null;
			boolean a=true; //for appending to an existing file
			try {
				fw=new FileWriter(filename2, a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			buffer=new BufferedReader(reader);
			String line=null;
			PrintWriter out=null;
			out=new PrintWriter(fw);
			
			try {
				line=buffer.readLine();
				
				while(line!=null) {
					out.println(line);
					line=buffer.readLine();
					out.flush();
				}
			} catch (IOException e) {
				System.out.println("error reading the file: "+ e.getMessage());
				e.printStackTrace();
			}
			if(fw!=null) {
				try {
					fw.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
