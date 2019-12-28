package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserPassword {
	
	public static String fileName="D://pass.txt";
	public static void main(String[] args) {
		
		File file= new File(fileName);
		boolean fileExists=file.exists();
		System.out.println("file available? " + file.exists());
		
		if(fileExists) {
		System.out.println(file.getPath());
		FileReader reader=null;
		BufferedReader buffer=null;
		
		try {
			reader=new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		buffer= new BufferedReader(reader);
		String line=null;
		try {
			line=buffer.readLine();
			String[] arr=new String[2];
			
			while(line!=null) {
			arr=line.split(":");
			System.out.println("User name: "+arr[0]+" Password: "+arr[1]);
			line=buffer.readLine();
			
			}
		} catch (IOException e) {
			System.out.println("error reading the file: "+ e.getMessage());
			e.printStackTrace();
		}
		finally{
			if(buffer != null) {
				try {
					buffer.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(reader!=null) {
				try {
					reader.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		}
	}

}
