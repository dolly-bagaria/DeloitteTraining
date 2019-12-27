package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VowelCountMap {

	public static void main(String[] args) {
		List<String> list=listCreate();
		Map<String,Integer> map= mapCreate(list);
		if(!map.isEmpty()) {
		System.out.println(map);
		
		Scanner s= new Scanner(System.in);
		System.out.println("enter a word to find the no. of vowels in it");
		String st= s.nextLine();
		
		findCount(st,map);
		}
	}
	
	
	public static List<String> listCreate() {
		String str="";
		Scanner s= new Scanner(System.in);
		ArrayList<String> list=new ArrayList<>();
		
		System.out.println("enter words: ");
		System.out.println("==enter quit to end word input==");
		for(;;) {
			str=s.nextLine();
			if(str.equalsIgnoreCase("quit"))
				break;
			else
				list.add(str);
		}
		//System.out.println(list);
		//System.out.println(mapCreate(list));
		return list;
		

	}
	public static int countVowel(String s) {
		int count=0;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch== 'u') {
				count++;
			}
		}
		return count;
	}
	
	public static Map<String,Integer> mapCreate(List<String> list) {
		Map<String, Integer> map=new HashMap<>();
		Iterator<String> iter=list.iterator();
		while(iter.hasNext()) {
			String word=iter.next();
			int count= countVowel(word);
			map.put(word, count);
		}
		return map;
	}

	public static void findCount(String st, Map<String, Integer> map) {
		if(map.containsKey(st)) {
			System.out.println(map.get(st));
		}
	}
}
