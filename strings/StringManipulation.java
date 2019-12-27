package strings;

import java.util.Arrays;

public class StringManipulation {
	
	public static void main(String[] args) {
		String str= new String();
		str="This is a test";
		String st= new String("this is a line of text in a paragraph");
		System.out.println(str==st);
		System.out.println(str.equals(st));
		str=st;
		System.out.println(str==st);
		System.out.println(str.equals(st));
		
		int len=str.length();
		System.out.println(str.indexOf("t"));
		
		int lastIndexOft=str.lastIndexOf("t");
		System.out.println(lastIndexOft);
		
		int count=0;
		for(char c: str.toCharArray()) {  //enhanced for loop
			if(c=='t')
				++count;
		}
		System.out.println("t occurs "+count+ " times.");
		
		String word="line of text";
		locate(word,str);
		
		StringBuffer buffer=new StringBuffer();
		buffer.append("<html>");
		buffer.append("<head> <title> My Web Page </title> </head>");
		buffer.append("<body>");
		buffer.append("<h1>This is my web profile</h1>");
		buffer.append("</body> </html>");
		
		System.out.println(buffer.toString());
		
		System.out.println(checkPalindrome("malayalam"));
		
		String line="the quick brown fox jumps over a lazy dog";
		countAlphabets(line);
		
	}
	
	public static void countAlphabets(String str) {
		//StringBuffer buffer=new StringBuffer(str);
		String c="";
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			if(!c.contains(ch+"") && ch!=' ') {
				c+=ch;
			}
		}
		System.out.println(c.length());
		char[] ch= c.toCharArray();
		Arrays.sort(ch);
		System.out.println(new String(ch));
	}
	
	public static boolean checkPalindrome(String str) {
		StringBuffer buffer=new StringBuffer(str);
		buffer= buffer.reverse();
		
		return buffer.toString().equals(str);
	}
	
	public static void locate(String word, String str) {
		if(str.contains(word)) {
			int start=str.indexOf(word);
			int end=start+ word.length()-1;
			System.out.println(start+", "+end);
			
			System.out.println(str.substring(start,end+1));
		}
		else
			System.out.println("word is not present");
	}
	

}
